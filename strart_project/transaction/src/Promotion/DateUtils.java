package Promotion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date parseDate(String dateStr){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            return formatter.parse(dateStr);
        } catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
