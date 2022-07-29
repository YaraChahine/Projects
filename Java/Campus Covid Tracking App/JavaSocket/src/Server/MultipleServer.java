package Server;

import java.io.*;
import java.sql.*;
import java.net.*;

public class MultipleServer {

    public static Connection con;

    public static void main(String[] args) throws IOException {
        String url = "jdbc:mysql://localhost:3306/COVID_Project";
        String userName = "root";
        String password = "root@MySQLv8.0.27";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServerSocket serverSocket = new ServerSocket(5056);

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();

                System.out.println("A new client is connected : " + clientSocket);

                DataInputStream inputFromClient = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(clientSocket.getOutputStream());

                System.out.println("Assigning new thread for this client");

                System.out.println("-----------------------------------------------------------------------------------");

                Thread thread = new ClientHandler(clientSocket, con, inputFromClient, outputToClient);
                thread.start();

            } catch (Exception e) {
                clientSocket.close();
                e.printStackTrace();
            }
        }
    }
}

// Server.ClientHandler class
class ClientHandler extends Thread {
    final Socket clientSocket;
    Connection connection;
    final DataInputStream inputFromClient;
    final DataOutputStream outputToClient;
    Thread locationThread;
    Thread exposedThread;
    InsertLocation insertLocation;
    DatabaseInfo databaseInfo;
    UserStatus userStatus;

    public ClientHandler(Socket clientSocket, Connection connection, DataInputStream inputFromClient, DataOutputStream outputToClient) {
        this.clientSocket = clientSocket;
        this.connection = connection;
        this.inputFromClient = inputFromClient;
        this.outputToClient = outputToClient;
    }

    @Override
    public void run() {
        // Variables
        String received;
        String toReturn;
        boolean done = false;
        boolean clientClosed = false;
        String username = "";
        int counter = 0;

        while (!done) {
            try {
                received = inputFromClient.readUTF();

                if (received.equalsIgnoreCase("Exit")) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Client " + this.clientSocket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.clientSocket.close();
                    clientClosed = true;
                    System.out.println("Connection closed");
                    if (insertLocation != null) {
                        insertLocation.timer.cancel();
                    }
                    break;
                }

                String[] strings = received.split("\n");

                switch (strings[0]) {

                    case "Login":
                        UserLogin userLogin = new UserLogin(strings[1], strings[2]);
                        boolean bool = userLogin.authenticateUser(connection);
                        if (bool) {
                            outputToClient.writeUTF("correct");
                            username = userLogin.username;
                            insertLocation = new InsertLocation(userLogin.username, connection);
                            locationThread = insertLocation;
                            locationThread.start();
                            databaseInfo = new DatabaseInfo(username, connection);
                            exposedThread = new CheckExposedUsers(username, databaseInfo);
                            exposedThread.start();
                            databaseInfo.setOnline();
                            done = true;
                        } else {
                            outputToClient.writeUTF("wrong password or username!");
                        }
                        break;

                    case "Signup":
                        boolean userDoneSignup = false;
                        while (true) {
                            received = inputFromClient.readUTF();
                            String[] userInfo = received.split("\n");

                            if (received.equalsIgnoreCase("back")) {
                                break;
                            }
                            if (received.equals("Exit")) {
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("Client " + this.clientSocket + " sends exit...");
                                System.out.println("Closing this connection.");
                                this.clientSocket.close();
                                clientClosed = true;
                                System.out.println("Connection closed");
                                if (insertLocation != null) {
                                    insertLocation.timer.cancel();
                                }
                                databaseInfo.setOffline();
                                break;
                            }

                            String firstName = userInfo[0];
                            String lastName = userInfo[1];
                            String email = userInfo[2];
                            username = userInfo[3];
                            String password = userInfo[4];
                            String photo = userInfo[5];
                            Boolean vaccinated = false;
                            if (userInfo[6].equalsIgnoreCase("Vaccinated")) {
                                vaccinated = true;
                            }
                            String vaccinationCard = userInfo[7];
                            CreateNewAccount createNewAccount = new CreateNewAccount(photo, firstName, lastName, email, username, password, vaccinated, vaccinationCard);
                            userDoneSignup = createNewAccount.setToDB(connection);
                            if (userDoneSignup) {
                                done = true;
                                insertLocation = new InsertLocation(username, connection);
                                locationThread = insertLocation;
                                locationThread.start();
                                databaseInfo = new DatabaseInfo(username, connection);
                                exposedThread = new CheckExposedUsers(username, databaseInfo);
                                exposedThread.start();
                                outputToClient.writeUTF("Done");
                                databaseInfo.setOnline();
                                break;
                            } else {
                                outputToClient.writeUTF("Already exists");
                            }
                        }
                        break;
                    default:
                        System.out.println("[ERROR]: I am in Client Handler, switch part!");
                }

                if (done || clientClosed) {
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        while (!clientClosed) {
            try {

                System.out.println("[I AM LISTING]: Second While Loop");
                received = inputFromClient.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Client " + this.clientSocket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.clientSocket.close();
                    System.out.println("Connection closed");
                    insertLocation.timer.cancel();
                    databaseInfo.setOffline();
                    clientClosed = true;
                    break;
                }


                switch (received) {
                    case "AccountPage" -> {
                        userStatus = new UserStatus(databaseInfo.getUserStatus());
                        System.out.println("[I AM IN]: AccountPage");
                        outputToClient.writeUTF(databaseInfo.getUserStatus());
                        outputToClient.writeUTF(userStatus.getInstruction(connection));
                    }
                    case "NumberOfActiveCases" -> {
                        System.out.println("[I AM IN]: NumberOfActiveCases");
                        String str = "" + databaseInfo.getActiveCases();
                        outputToClient.writeUTF(str);
                    }
                    case "ViewTrustedPeopleList" -> {
                        System.out.println("[I AM IN]: ViewTrustedPeopleList");
                        outputToClient.writeUTF(databaseInfo.getUsernameNotListedTrust());
                        outputToClient.writeUTF(databaseInfo.getUsernameListedTrust());
                        while (true) {
                            try {
                                received = inputFromClient.readUTF();
                                String[] userInfo = received.split("\n");
                                if (userInfo[0].equalsIgnoreCase("Exit")) {
                                    System.out.println("-----------------------------------------------------------------------------------");
                                    System.out.println("Client " + this.clientSocket + " sends exit...");
                                    System.out.println("Closing this connection.");
                                    this.clientSocket.close();
                                    System.out.println("Connection closed");
                                    insertLocation.timer.cancel();
                                    databaseInfo.setOffline();
                                    clientClosed = true;
                                    break;
                                } else if (userInfo[0].equalsIgnoreCase("Add")) {
                                    databaseInfo.insertFriendToMyTrustedList(userInfo[1]);
                                } else if (userInfo[0].equalsIgnoreCase("Remove")) {
                                    databaseInfo.removeFriendFromTrustedList(userInfo[1]);
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    case "CheckOnMyFriends" -> {
                        System.out.println("[I AM IN]: CheckOnMyFriends");
                        outputToClient.writeUTF(databaseInfo.getFriendsListedMeTrust());
                    }
                    case "SubmitPCRResult" -> {
                        System.out.println("[I AM IN]: SubmitPCRResult");
                        received = inputFromClient.readUTF();
                        String[] userInfo = received.split("\n");
                        switch (userInfo[0]) {
                            case "submit":
                                String s = userInfo[1];
                                databaseInfo.insertPCRResult(userInfo[1]);
                                System.out.println(s);
                                break;
                            case "Exit":
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("Client " + this.clientSocket + " sends exit...");
                                System.out.println("Closing this connection.");
                                this.clientSocket.close();
                                System.out.println("Connection closed");
                                insertLocation.timer.cancel();
                                clientClosed = true;
                                databaseInfo.setOffline();
                                break;
                            default:
                                break;
                        }
                    }
                    case "CheckQuarantineDays" -> {
                        System.out.println("[I AM IN]: CheckQuarantineDays");
                        if (databaseInfo.getPCRResult().equalsIgnoreCase("positive")) {
                            outputToClient.writeUTF("You have been " + databaseInfo.getQuarantineDays() + " days\n in quarantine.");
                        } else {
                            outputToClient.writeUTF("You are free of CORONA!\nStay safe, and keep your mask on!");
                        }
                    }
                    default -> outputToClient.writeUTF("Invalid input");
                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            // Closing resources
            this.inputFromClient.close();
            this.outputToClient.close();
            databaseInfo.setOffline();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}