package utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
    public static final int ONLY_WEEK = 1;

    public static String getWeekOfYear(String date, int fmt) {
        if(date == null) return "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            try{
                cal.setTime(format.parse(date));
            } catch (ParseException e1) {
                e.printStackTrace();
                return "";
            }
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        int year = cal.get(Calendar.YEAR);
        if (isFirstWeek(cal)){
            year -= 1;
        }
        if (fmt == ONLY_WEEK){
            return "" + cal.get(Calendar.WEEK_OF_YEAR);
        }
        else{
            return year + " " + cal.get(Calendar.WEEK_OF_YEAR);
        }
    }

    public static String getWeekOfYear(String date) {
        return getWeekOfYear(date, 0);
    }

    public static int getQuarterOfYear(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            try{
                cal.setTime(format.parse(date));
            } catch (ParseException e1) {
                e.printStackTrace();
                return 0;
            }
        }
        return cal.get(Calendar.MONTH) / 3 + 1;
    }

    public static String unifyDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat minute = new SimpleDateFormat("yyyy MM dd HH mm");
                minute.setLenient(true);
                return format.format(minute.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat hour = new SimpleDateFormat("yyyy MM dd HH");
                hour.setLenient(true);
                return format.format(hour.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2} \\d{1,2}$")) {
                SimpleDateFormat day = new SimpleDateFormat("yyyy MM dd");
                day.setLenient(true);
                return format.format(day.parse(date));
            }
            if (date.matches("^\\d{4} \\d{1,2}$")) {
                SimpleDateFormat month = new SimpleDateFormat("yyyy MM");
                month.setLenient(true);
                return format.format(month.parse(date));
            }
            if (date.matches("^\\d{4}$")) {
                SimpleDateFormat year = new SimpleDateFormat("yyyy");
                year.setLenient(true);
                return format.format(year.parse(date));
            }
        } catch (ParseException e){
            return date;
        }
        return date;
    }

    protected static boolean isFirstWeek(Calendar cal){
        if (cal.get(Calendar.MONTH) == 0){
            return cal.get(Calendar.WEEK_OF_YEAR) == 52 || cal.get(Calendar.WEEK_OF_YEAR) == 53;
        }
        return false;
    }

    public static String getFirstDayOfMonth(int year, int month){
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dt=cal.getTime();
        return format.format(dt);
    }

    public static String getLastDayOfMonth(int year, int month){
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        Date dt=cal.getTime();
        return format.format(dt);
    }

    public static int getWorkDayOfMonth(int year, int month){
        int work_day_count = 0;
        Calendar cal = new GregorianCalendar();
        year = (year != 0) ? year : cal.get(Calendar.YEAR);
        month = (month != 0) ? month : cal.get(Calendar.MONTH) + 1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = year+"-"+month+"-1 00:00:00";

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);


        while(cal.get(Calendar.YEAR) == year &&
                cal.get(Calendar.MONTH) < month){
            int day = cal.get(Calendar.DAY_OF_WEEK);

            if(!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)){
                ++work_day_count;
            }
            cal.add(Calendar.DATE, 1);
        }
        return work_day_count;
    }

    public static String getDayOfWeek(String date) {
        Calendar cal = new GregorianCalendar();
        Date fmt_date = DateUtil.parse(date);
        if(fmt_date == null){
            return "0";
        }
        cal.setTime(fmt_date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day_of_week = (cal.get(Calendar.DAY_OF_WEEK) == 1) ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        return "" + day_of_week;
    }

    public static String newGetDayOfWeek(String date) throws ParseException {
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date fmt_date = sdf.parse(date);
        cal.setTime(fmt_date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day_of_week = (cal.get(Calendar.DAY_OF_WEEK) == 1) ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        return "" + day_of_week;
    }

    public static Date parse(String value){
        if (value == null) {
            return null;
        }
        try {
            String dateStr = value.length() == 10 ? value + " 00:00:00" : value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static DateTime parseDateTime(String value) {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String dateStr = value.length() == 10 ? value + " 00:00:00" : value;
        return dtf.parseDateTime(dateStr);
    }

    public static String dateConvert(long value){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = sdf.format(new Date(value*1000));
    	return date;
    }

    public static DateTime getDateTimeByWeekNumber(int year, int week){
        DateTime dt = new DateTime(year, 1, 1, 0, 0, 0);
        while (dt.getDayOfWeek() != 1){
            dt = dt.plusDays(1);
        }
        return dt.plusDays(7 * (week - 1));
    }
    public static String getDateAfterMonths(String date,int add){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(date));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        int addYear = (add+month)/12;
        int diffMonth = (month+add)%12;
        cal.add(Calendar.YEAR, addYear);
        cal.set(Calendar.MONTH, diffMonth-1);
        if(day>28){
            cal.add(Calendar.DATE, -3);
            int targetMonthMaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.add(Calendar.DATE, 3);
            if(day > targetMonthMaxDay){
                cal.add(Calendar.MONTH, -1);
                cal.set(Calendar.DATE, targetMonthMaxDay);
            }
        }
        Date dt=cal.getTime();
        return format.format(dt);
    }

    public static String getWeekRange(int year, int week){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        Date date = cal.getTime();
        System.out.println(format.format(date));
        int weeks = getMaxWeekNumOfYear(year);
        System.out.println(weeks);
        System.out.println(week);
        Date date2;
        if (week == weeks){
            Calendar cal1 = new GregorianCalendar();
            cal1.set(Calendar.YEAR, year+1);
            cal1.setMinimalDaysInFirstWeek(7);
            cal1.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.set(Calendar.WEEK_OF_YEAR, 1);
            date2 = cal1.getTime();
        }else {
            Calendar cal1 = new GregorianCalendar();
            cal1.set(Calendar.YEAR, year);
            cal1.setMinimalDaysInFirstWeek(7);
            cal1.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.set(Calendar.WEEK_OF_YEAR, week+1);
            date2 = cal1.getTime();
        }
        System.out.println(format.format(date2));
        return "("+format.format(date)+"~"+format.format(date2)+")";
    }

    public static int getWeeksOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }
    public static int getMaxWeekNumOfYear(int year) {
        Calendar cal = new GregorianCalendar();
        cal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

        return getWeeksOfYear(cal.getTime());
    }

}
