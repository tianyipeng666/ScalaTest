package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {
        Date nowTime = new Date();
        long nowSeconds = nowTime.getTime() / 1000;
        System.out.println("now Time =>" + nowSeconds);
        Date intervalStartTime = getIntervalStartTime(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("interval Time =>" + simpleDateFormat.format(intervalStartTime.getTime()));
        if (new Date(nowSeconds * 1000).after(intervalStartTime)) {
            System.out.println("true");
        }
    }

    public static Date getIntervalStartTime(Integer interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -interval);
        return calendar.getTime();
    }
}
