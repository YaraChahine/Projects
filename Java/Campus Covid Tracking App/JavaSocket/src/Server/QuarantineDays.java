package Server;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;

public class QuarantineDays {

    public Connection connection;
    public String username;
    public int quarantineDays;
    public DatabaseInfo databaseInfo;
    public Date now;
    public String dateRetrievedFromDB;
    public DateFormat format;

    public QuarantineDays(String username, Connection connection) {
        this.connection = connection;
        this.username = username;
        this.now = new Date();
        this.databaseInfo = new DatabaseInfo(username, connection);
    }

    public int getQuarantineDays(){
        try {
            dateRetrievedFromDB = databaseInfo.getInfectedDate();
            Date firstDate = format.parse(dateRetrievedFromDB);
            long diff = now.getTime() - firstDate.getTime();
            quarantineDays = (int) (diff/3600000)/24;
        }catch (Exception e){
            e.printStackTrace();
        }
        return quarantineDays;
    }

}
