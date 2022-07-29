package Server;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DatabaseInfo {

    public String username;
    public Connection connection;
    public String query;
    public String active;

    public DatabaseInfo(String username, Connection connection) {
        this.username = username;
        this.connection = connection;
        this.active = "online";
    }

    public void setOnline() {
        try {
            String query = "UPDATE users SET active ='online' WHERE username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setOffline() {
        try {
            String query = "UPDATE users SET active ='offline' WHERE username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getActiveCases() {
        try {
            query = "SELECT COUNT(*) from users where status = 'contagious'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getUsernameNotListedTrust() {
        try {
            String query = "SELECT username from users where username not in (SELECT trusted_user from trustedFriends where username = ?) AND username != ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.setString(2, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            String str = "";
            while (resultSet.next()) {
                str += resultSet.getString(1) + "\n";
            }
            pStmt2.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getUsernameListedTrust() {
        try {
            String query = "SELECT trusted_user from trustedFriends where username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            String str = "";
            while (resultSet.next()) {
                str += resultSet.getString(1) + "\n";
            }
            pStmt2.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFriendsListedMeTrust() {
        try {
            String query = "SELECT username, status from users where username in (SELECT username from trustedFriends where trusted_user = ?)";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            String str = "";
            while (resultSet.next()) {
                str += resultSet.getString(1) + "\n" + resultSet.getString(2) + "\n";
            }
            pStmt2.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void insertFriendToMyTrustedList(String friendUsername) {
        try {
            String query = "INSERT into trustedFriends VALUES(?,?)";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.setString(2, friendUsername);
            pStmt2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeFriendFromTrustedList(String friendUsername) {
        try {
            String query = "DELETE FROM trustedFriends WHERE (username=? AND trusted_user = ?)";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.setString(2, friendUsername);
            pStmt2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getInfectedDate() {
        try {
            String query = "SELECT infected_date FROM users where username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            resultSet.next();
            return resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void insertInfectedDate() {
        try {
            LocalDate date = LocalDate.now();
            String query = "UPDATE users SET infected_date = ? WHERE username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, date.toString());
            pStmt2.setString(2, username);
            pStmt2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPCRResult(String pcrResult) {
        try {
//            if (!getPCRResult().equalsIgnoreCase("positive")) {
                String query = "UPDATE users SET pcr_result = ? WHERE username = ?";
                PreparedStatement pStmt2 = connection.prepareStatement(query);
                pStmt2.setString(1, pcrResult);
                pStmt2.setString(2, username);
                updateUserStatus(pcrResult);
                pStmt2.execute();
                if (pcrResult.equals("positive") && !getPCRResult().equalsIgnoreCase("positive")) {
                    insertInfectedDate();
                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPCRResult() {
        try {
            String query = "SELECT pcr_result FROM users where username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            resultSet.next();
            return resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void updateUserStatus(String pcrResult) {
        try {
            String query = "UPDATE users SET status = ? WHERE username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            if (pcrResult.equals("positive")) {
                pStmt2.setString(1, "contagious");
            } else {
                pStmt2.setString(1, "safe");
            }
            pStmt2.setString(2, username);
            pStmt2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserStatus() {
        try {
            String query = "SELECT status FROM users where username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            resultSet.next();
            return resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setUserStatus(String status) {
        try {
            String query = "UPDATE users SET status = ? WHERE username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, status);
            pStmt2.setString(2, username);
            pStmt2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLocationAndArrivedTime() {
        try {
            String query = "SELECT location, time_arrived FROM users where username = ?";
            PreparedStatement pStmt2 = connection.prepareStatement(query);
            pStmt2.setString(1, username);
            pStmt2.execute();
            ResultSet resultSet = pStmt2.getResultSet();
            String location = "";
            String arrived_time = "";
            while (resultSet.next()) {
                location = resultSet.getString(1);
                arrived_time = resultSet.getString(2);
            }
            return location + "\n" + arrived_time;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getQuarantineDays() {
        try {
            String infectedDateString = getInfectedDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date infectedDate = format.parse(infectedDateString);
            Date currentDate = new Date();
            long diff = currentDate.getTime() - infectedDate.getTime();
            int days = (int) (diff / 3600000) / 24;
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

//    public boolean updateInfectedDate(String pcrResult) {
//        try {
//            String query = "UPDATE users SET infected_date = ? WHERE username = ?";
//            PreparedStatement pStmt2 = connection.prepareStatement(query);
//            Date date =
//            pStmt2.setString(1, );
//            pStmt2.setString(2, username);
//            return pStmt2.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

}
