package com.safe.info.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 */
public class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String SP1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String SP2 = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd
     */
    public static final String SP3 = "yyyy-MM-dd";

    /**
     * yyyyMMdd
     */
    public static final String SP4 = "yyyyMMdd";

    /**
     * yyyy-MM
     */
    public static final String SP5 = "yyyy-MM";

    public static final String SP6 = "yyyy年MM月dd日";

    /**
     * 将时间以指定格式格式化
     *
     * @param time 待转换时间
     * @param formatStrBefore 转换前时间格式
     * @param formatStrAfter 转换后时间格式
     * @return
     * @throws Exception
     */
    public static String parseTime(String time, String formatStrBefore, String formatStrAfter)
            throws ParseException {
        SimpleDateFormat bfSp = new SimpleDateFormat(formatStrBefore);
        SimpleDateFormat afSp = new SimpleDateFormat(formatStrAfter);
        return afSp.format(bfSp.parse(time));
    }

    /**
     * 将时间以指定格式格式化
     *
     * @param time 待转换时间
     * @param formatStrAfter 转换后时间格式
     * @return
     * @throws Exception
     */
    public static String parseTime(Date time, String formatStrAfter) throws ParseException {
        SimpleDateFormat afSp = new SimpleDateFormat(formatStrAfter);
        return afSp.format(time);
    }

    /**
     * 比较时间前后
     *
     * @param time1 时间1
     * @param time2 时间2
     * @param formatStr 时间格式
     * @return 时间1比时间2早则返回1 时间1比时间2晚则返回-1 时间1等于时间2则返回0
     * @throws ParseException
     */
    public static int compareTime(String time1, String time2, String formatStr)
            throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Date date1 = sp.parse(time1);
        Date date2 = sp.parse(time2);
        if (date1.before(date2)) {
            return 1;
        } else if (date1.after(date2)) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 获得指定格式的当前时间
     *
     * @param formatStr 时间格式
     * @return
     */
    public static String getCurrentTime(String formatStr) {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        return sp.format(new Date());
    }

    /**
     * 获取指定格式的某时间,例如1小时前 或者1小时后
     *
     * @param field 例如Calendar.DAY_OF_MONTH
     * @param amount 整数 例如-1
     * @param formatStr 时间格式
     * @return
     */
    public static String getTimeAfter(int field, int amount, String formatStr) {
        Calendar cal = Calendar.getInstance();
        cal.add(field, amount);
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        return sp.format(cal.getTime());
    }

    /**
     * 获取当月第一天
     *
     * @param formatStr
     * @return
     */
    public static String getFirstDayOfMonth(String formatStr) {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Calendar date = Calendar.getInstance();// 今天
        date.set(Calendar.DAY_OF_MONTH, 1);// 设置日期为本月第1天
        date.set(Calendar.HOUR_OF_DAY, 0);// 设置时
        date.set(Calendar.MINUTE, 0);// 设置分
        date.set(Calendar.SECOND, 0);// 设置秒
        return sp.format(date.getTime());
    }

    /**
     * 日期/时间 计算
     *
     * @param time 待计算时间
     * @param formatStr 时间格式
     * @param addpart 可选 Y M D H F S
     * @param num 增加或者减少量(整数)
     * @return
     * @throws Exception
     */
    public static String calculateTime(String time, String formatStr, String addpart, int num)
            throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dateFormat.parse(time));
        if (addpart.equalsIgnoreCase("Y")) {
            cal.add(Calendar.YEAR, num);
        } else if (addpart.equalsIgnoreCase("M")) {
            cal.add(Calendar.MONTH, num);
        } else if (addpart.equalsIgnoreCase("D")) {
            cal.add(Calendar.DATE, num);
        } else if (addpart.equalsIgnoreCase("H")) {
            cal.add(Calendar.HOUR, num);
        } else if (addpart.equalsIgnoreCase("F")) {
            cal.add(Calendar.MINUTE, num);
        } else if (addpart.equalsIgnoreCase("S")) {
            cal.add(Calendar.SECOND, num);
        }
        return dateFormat.format(cal.getTime());
    }

    public static Date calculateTime(Date date, String addpart, int num) throws ParseException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        if (addpart.equalsIgnoreCase("Y")) {
            cal.add(Calendar.YEAR, num);
        } else if (addpart.equalsIgnoreCase("M")) {
            cal.add(Calendar.MONTH, num);
        } else if (addpart.equalsIgnoreCase("D")) {
            cal.add(Calendar.DATE, num);
        } else if (addpart.equalsIgnoreCase("H")) {
            cal.add(Calendar.HOUR, num);
        } else if (addpart.equalsIgnoreCase("F")) {
            cal.add(Calendar.MINUTE, num);
        } else if (addpart.equalsIgnoreCase("S")) {
            cal.add(Calendar.SECOND, num);
        }
        return cal.getTime();
    }

    /**
     * 返回两个时间之间的差(毫秒数)
     *
     * @param time1
     * @param time2
     * @param formatStr
     * @return
     * @throws ParseException
     */
    public static long dateDiffer(String time1, String time2, String formatStr)
            throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat(formatStr);
        Date date1 = sp.parse(time1);
        Date date2 = sp.parse(time2);
        long differ = Math.abs(date1.getTime() - date2.getTime());
        return differ;
    }

    /**
     * 将日期置为当天23:59:59.999
     *
     * @param date
     * @return
     */
    public static Date getEndOfTheDay(Date date) {
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 将日期置为当天00:00:00.000
     *
     * @param date
     * @return
     */
    public static Date getStartOfTheDay(Date date) {
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 000);
        return cal.getTime();
    }

    public static boolean isSameDay(Date d1, Date d2) {
        if (getStartOfTheDay(d1).getTime() == getStartOfTheDay(d2).getTime()) {
            return true;
        }
        return false;
    }

}

