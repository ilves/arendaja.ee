package ee.golive.arendaja.helper;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
    public static String relativeDateTime(Date inputDateTime, boolean ignoreDate) {
        String outputDateTime = "";
        Long diff = ((new Date().getTime()) - inputDateTime.getTime())/1000;
        System.out.println((new Date().getTime()) + " - " + inputDateTime.getTime() + " = " + diff);
        if (diff > 60*60*24*7 && !ignoreDate) {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
            outputDateTime = myFormat.format(inputDateTime);
        } else if (diff > 60*60*24) {
            int days = Math.round(diff/(60*60*24));
            outputDateTime = days == 1 ? ("about 1 Day ago") : ("about " + days + " Days ago");
        } else if (diff > 60*60) {
            int hours = Math.round(diff/(60*60));
            outputDateTime = hours == 1 ? ("an hour ago") : (hours + " hours ago");
        } else if (diff > 60) {
            int minutes = Math.round(diff/(60));
            outputDateTime = minutes == 1 ? ("1 minute ago") : (minutes + " minutes ago");
        } else {
            outputDateTime = "few seconds ago";
        }
        return outputDateTime;
    }
}
