import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Reminder {

    static Timer timer;
    public int seconds;
    public static int counter = 0;
    public Reminder(int seconds) {
        this.seconds = seconds;
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            counter++;
            System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
            if(counter != 2) {
                System.out.println(counter);
                new Reminder(seconds);
            }else {
                timer.cancel();
                System.out.println("Canceled!");
            }
        }
    }

    public static void main(String[] args) {

        new Reminder(5);
        System.out.println("Task scheduled.");


//        while (true){
//            System.out.println(counter);
//            if(counter == 2){
//                System.out.println("am in if!");
//                timer.cancel();
//                break;
//            }
//        }
//        System.out.println("Canceled!");

//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//            Date firstDate = sdf.parse("11/20/2021");
//            Date secondDate = sdf.parse("12/01/2021");
//
//            long diff = secondDate.getTime() - firstDate.getTime();
//            System.out.println((diff/3600000)/24);
//
//            TimeUnit time = TimeUnit.DAYS;
//            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
//            System.out.println("The difference in days is : " + diffrence);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        String ds = "November 22, 2021";
//        DateFormat dff = DateFormat.getDateInstance();
//        Date d = null;
//        try {
//            d = dff.parse(ds);
//            System.out.println(d);
//        }
//        catch(ParseException e) {
//            System.out.println("Unable to parse " + ds);
//        }
//
//        Date now = new Date();
//        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
//        String s = df.format(now);
//        System.out.println("Today is " + s);
//
//        Date diff = new Date(d.getTime() - now.getTime());
//        DateFormat dfff = DateFormat.getDateInstance(DateFormat.SHORT);
//        String str = dfff.format(diff);
//
//        System.out.println(str);
    }
}
