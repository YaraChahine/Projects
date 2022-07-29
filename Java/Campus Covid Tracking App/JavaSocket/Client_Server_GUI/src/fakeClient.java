import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class fakeClient {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/COVID_Project";
        String userName ="root";
        String password ="root@MySQLv8.0.27";

        String query = "Select * from users where username = \"will_smith\"";

        try {
            //com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, userName, password);
//            FileInputStream photo = new FileInputStream("C:\\Users\\lenovo\\IdeaProjects\\JavaSocket\\Client_Server_GUI\\src\\svyatoslav-romanov-r38u2Uq1AXk-unsplash (1).jpg");
//            createNewAccount account = new createNewAccount(photo, "Adam", "Smith", "adam@gmail.com", "will_smith", "12345678", false, "0101");
//            account.setToDB(con);


            UserStatus userStatus = new UserStatus("risk");
            String str = userStatus.getInstruction(con);
            System.out.println(str);

            LocalDate localDate = LocalDate.now();
            java.util.Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            TrackingDays trackingDays = new TrackingDays(userStatus, date);
            TimerClock timerClock = new TimerClock(86400, trackingDays);


            while(true){
                if(trackingDays.getNumOfDays() == 14){

                }
            }

//            UserLogin login = new UserLogin("will_smith", "124678");
//            Boolean b = login.authenticateUser(con);

//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);

//            rs.next();
//            Blob photo = rs.getBlob(1);
//            InputStream is = photo.getBinaryStream();
//            int data = is.read();
//            int counter =0;
//            while (data != -1){
//                counter ++;
//                data = is.read();
//            }
//            System.out.println(counter);
//            byte[] byteArray = new byte[is.available()];
//            is.read(byteArray);
//            String filePath = "C:\\Users\\lenovo\\IdeaProjects\\JavaSocket\\Client_Server_GUI\\src" + "\\pic.jpg";
//            FileOutputStream outPutStream = new FileOutputStream(filePath);
//            outPutStream.write(byteArray);
//            System.out.println(filePath);

//			while(rs.next()) {
//				String row = "";
//                for(int i=1; i<=8; i++) {
//                    row += rs.getString(i) + " : ";
//				}
//				System.out.println(row);
//			}

        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
