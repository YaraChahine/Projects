package Server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckExposedUsers extends Thread{

    public String username;
    public DatabaseInfo databaseInfo;
    public SimpleDateFormat dateFormat;

    public CheckExposedUsers(String username, DatabaseInfo databaseInfo){
     this.username = username;
     this.databaseInfo = databaseInfo;
     this.dateFormat = new SimpleDateFormat("E MMM dd hh:mm:ss ZZZ yyyy");
    }

    @Override
    public void run() {
        while(true) {
            while (!databaseInfo.getUserStatus().equalsIgnoreCase("contagious") && !databaseInfo.getUserStatus().equalsIgnoreCase("risk")) {
                try {
                    ArrayList<String> list = new ArrayList<>();
                    String locationAndArrivedTime = databaseInfo.getLocationAndArrivedTime();
                    String[] strings = locationAndArrivedTime.split("\n");
                    String location = strings[0];
                    String arrivedTimeStr = strings[1];
                    Date myTime = dateFormat.parse(arrivedTimeStr);
                    String query = "select time_arrived from users where active = 'online' AND location = ? AND status = 'contagious'";
                    PreparedStatement pStmt2 = databaseInfo.connection.prepareStatement(query);
                    pStmt2.setString(1, location);
                    pStmt2.execute();
                    ResultSet resultSet = pStmt2.getResultSet();
                    while (resultSet.next()) {
                        list.add(resultSet.getString(1));
                    }

                    for (int i = 0; i < list.size(); i++) {
                        Date userTime = dateFormat.parse(list.get(i));
                        long diff = myTime.getTime() - userTime.getTime();
                        long difference_In_Minutes;
                        Date now = new Date();
                        if (diff >= 0) {
                            diff = now.getTime() - myTime.getTime();
                        } else {
                            diff = now.getTime() - userTime.getTime();
                        }
                        difference_In_Minutes = (diff / (1000 * 60)) % 60;
                        if (difference_In_Minutes >= 1) {
                            databaseInfo.setUserStatus("risk");
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
