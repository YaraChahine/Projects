import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class draftMain {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();

        LocalDate myObj = LocalDate.now();

        String str = date.toString();
        System.out.println(date.toString());
        System.out.println(myObj.toString());

        String infectedDate = "Sun Nov 28 16:43:12 EET 2021";
        SimpleDateFormat format = new SimpleDateFormat("E MMM dd hh:mm:ss ZZZ yyyy");
        Date date1 = format.parse(infectedDate);
        System.out.println(date1);


        long diff = date1.getTime() - date.getTime();
        long difference_In_Minutes = (diff / (1000 * 60)) % 60;
        System.out.println(difference_In_Minutes);

        System.out.println();

    }

}
