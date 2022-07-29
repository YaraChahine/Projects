
import java.util.Date;

public class TrackingDays {

    public long numOfDays;
    public UserStatus userStatus;
    public Date firstDate;
    public Date currentDate;

    public TrackingDays(UserStatus userStatus, Date firstDate) {
        this.userStatus = userStatus;
        this.firstDate = firstDate;
        this.currentDate = firstDate;
    }

    public void calculateDifference(){
        long diff = currentDate.getTime() - firstDate.getTime();
        numOfDays = (diff/3600000)/24;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
        calculateDifference();
    }

    public long getNumOfDays() {
        return numOfDays;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

}
