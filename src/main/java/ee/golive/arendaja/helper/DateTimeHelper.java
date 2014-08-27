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
            outputDateTime = days == 1 ? ("umbes 1 p&auml;ev tagasi") : ("umbes " + days + " p&auml;eva tagasi");
        } else if (diff > 60*60) {
            int hours = Math.round(diff/(60*60));
            outputDateTime = hours == 1 ? ("tund aega tagasi") : (hours + " tundi tagasi");
        } else if (diff > 60) {
            int minutes = Math.round(diff/(60));
            outputDateTime = minutes == 1 ? ("minut aega tagasi") : (minutes + " minutit tagasi");
        } else {
            outputDateTime = "m&otilde;ni sekund tagasi";
        }
        return outputDateTime;
    }
}
