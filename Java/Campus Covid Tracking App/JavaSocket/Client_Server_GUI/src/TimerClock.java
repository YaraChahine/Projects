import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerClock {

    Timer timer;
    public int seconds;
    public TrackingDays trackingDays;

    public TimerClock(int seconds, TrackingDays trackingDays) {
        this.seconds = seconds;
        this.trackingDays = trackingDays;
        timer = new Timer();
        timer.schedule(new TimerClock.TimerClockTask(), seconds*1000);
    }

    class TimerClockTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            timer.cancel();

            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            trackingDays.setCurrentDate(date);

            if(trackingDays.getNumOfDays() != 15){
                new TimerClock(seconds, trackingDays);
            }else {
                trackingDays.getUserStatus().setStatus("safe");
                timer.cancel();
            }

        }
    }

}
