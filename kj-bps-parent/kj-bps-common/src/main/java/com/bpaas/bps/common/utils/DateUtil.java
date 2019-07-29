package com.bpaas.bps.common.utils;

import com.bpaas.bps.common.constants.Constants_comm;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 时间工具类
 * @version: 1.0
 */
public class DateUtil {

    private static int FIRST_DATE_OF_WEEK = Calendar.SUNDAY;

    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";

    /**
     * 获取自然日期 不包含时分秒
     *
     * @return
     */
    public static Date getNaturalDate() {
        return DateUtil.getYMD(new Date()).getTime();
    }

    /**
     * @param date1 起始日期
     * @param date2 结束日期
     * @return
     * @descrption 计算两个日期之间相差的月份
     */
    public static int getMonthSpace(String date1, String date2) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int diffYear = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        result = diffYear * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);
    }

    public static Date getCurrentTime() {
        String dateStr = format(new Date(), dtLong);
        Date date = parse(dateStr, dtLong);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTime();
    }

    public static String changYear(Date date, int year) throws ParseException {//123
        SimpleDateFormat sb = new SimpleDateFormat("yyyyMMdd");
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.YEAR, year);
        Date time = ca.getTime();
        return sb.format(time);
    }

    /**
     * 获取两个date之间的秒数
     *
     * @return
     */
    public static long difSeconds(Date d1, Date d2) {
        long c = d1.getTime() - d2.getTime();
        long result = c / 1000;
        return result;
    }

    /**
     * @param second
     * @return
     */
    public static boolean comPare24Time(long second) {
        long twenty = 24 * 60 * 60;
        if (twenty > second) {
            return false;
        } else if (twenty < second) {
            return true;
        } else if (twenty == second) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Formats a Date into a date/time string.
     *
     * @param date
     * @param pattern 格式 yyyyMMddHHmmss / yyMMdd /...
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    /**
     * Parses text from the beginning of the given string to produce a date.
     *
     * @param date    日期字符串
     * @param pattern 格式 yyyyMMddHHmmss / yyMMdd /...
     * @return
     * @throws ParseException
     */
    public static Date parse(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date d = sdf.parse(date);
            return d;
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误", e);
        }

    }


    /**
     * add(Calendar.DAY_OF_MONTH, -5)
     *
     * @param date
     * @param calendorField
     * @param amount
     * @return
     */
    public static Date add(Date date, int calendorField, int amount) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(calendorField, amount);

        return cal.getTime();
    }


    /**
     * @return Calendar.SUNDAY <br/>
     * Calendar.MONDAY <br/>
     * Calendar.TUESDAY <br/>
     * Calendar.WEDNESDAY <br/>
     * Calendar.THURSDAY <br/>
     * Calendar.FRIDAY <br/>
     * Calendar.SATURDAY <br/>
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return 6;
        }
    }


    /**
     * @return Calendar.SUNDAY <br/>
     * Calendar.MONDAY <br/>
     * Calendar.TUESDAY <br/>
     * Calendar.WEDNESDAY <br/>
     * Calendar.THURSDAY <br/>
     * Calendar.FRIDAY <br/>
     * Calendar.SATURDAY <br/>
     */
    public static int getDayOfMouth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 计算两个日期间相差的天数
     *
     * @param date
     * @param compareDate
     * @return
     * @throws ParseException
     */
    public static long compareTo(Date date, Date compareDate) {
        // 去掉时分秒
        date = parse(format(date, "yyMMdd"), "yyMMdd");
        compareDate = parse(format(compareDate, "yyMMdd"), "yyMMdd");

        long a = (date.getTime() - compareDate.getTime()) / (1000 * 60 * 60 * 24);
        return a;
    }


    /**
     * 判断是否为一周的最后一天(目前配置的是周日为一周的第一天)
     *
     * @param date
     * @return
     */
    public static boolean isEndOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        if (weekDay == FIRST_DATE_OF_WEEK) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为月末
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是月末 false 表示不为月末
     */
    public static boolean isMonthEnd(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为月初
     *
     * @param nowDate
     * @return
     */
    public static boolean isMonthBegin(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1) {
            return true;
        }
        return false;
    }


    /**
     * @param date
     * @return
     * @descrption 得到日期的年月
     */
    public static String findYearMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String dateMouth = year + "-" + (month < 10 ? "0" + month : month);
        return dateMouth;
    }


    /**
     * 判断时间是否为季末
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是季末 false 表示不是季末
     */
    public static boolean isQuarterEnd(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int month = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1
                && (month == Calendar.MARCH || month == Calendar.JUNE || month == Calendar.SEPTEMBER || month == Calendar.DECEMBER)) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为季出
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是季初 false 表示不是季初
     */
    public static boolean isQuarterBegin(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1
                && (month == Calendar.JANUARY || month == Calendar.APRIL || month == Calendar.JULY || month == Calendar.OCTOBER)) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为半年末
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是半年末 false 表示不是半年末
     */
    public static boolean isHalfYearEnd(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int month = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1 && (month == Calendar.JUNE || month == Calendar.DECEMBER)) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为半年出
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是半年初 false 表示不是半年初
     */
    public static boolean isHalfYearBegin(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day == 1 && (month == Calendar.JANUARY || month == Calendar.JULY)) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为年末
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是年末 false 表示不为年末
     */
    public static boolean isYearEnd(Date nowDate) {
        if ("1231".equals(format(nowDate, "MMdd"))) {
            return true;
        }
        return false;
    }


    /**
     * 判断时间是否为年初
     *
     * @param nowDate 日期（需要验证的日期）
     * @return boolean true 表示是年初 false 表示不为年初
     */
    public static boolean isYearBegin(Date nowDate) {
        if ("0101".equals(format(nowDate, "MMdd"))) {
            return true;
        }
        return false;
    }


    /**
     * @param date
     * @return
     * @descrption 获取日期的年月日
     */
    public static Calendar getYMD(Date date) {
        String dateStr = format(date, "yyyyMMdd");
        date = parse(dateStr, "yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    /**
     * 判断是否为结算日期
     *
     * @param stlCycle ,stlCycleDay,tranDate
     * @return boolean
     */
    public static boolean chkStlTime(String stlCycle, String stlCycleDay, Date tranDate) {
        boolean b = false;
        switch (stlCycle.toCharArray()[0]) {
            case '1':
                // 日结
                b = true;
                break;
            case '2':
                // 周结
                String nowDate = String.valueOf(DateUtil.getDayOfWeek(tranDate));
                if (nowDate.equals(stlCycleDay)) {
                    b = true;
                }
                break;
            case '3':
                // 月结
                if (stlCycleDay.equals("0")) {
                    // 月末结
                    boolean result = DateUtil.isMonthEnd(tranDate);
                    if (result) {
                        b = true;
                    }
                } else {
                    // 非月末结
                    String nowDate1 = String.valueOf(DateUtil.getDayOfMouth(tranDate));
                    if (nowDate1.equals(stlCycleDay)) {
                        b = true;
                    }
                }
                break;
            case '4':
                // 季结
                if ("1".equals(stlCycleDay)) {
                    // 季初
                    if (DateUtil.isQuarterBegin(tranDate)) {
                        b = true;
                    }
                } else if ("0".equals(stlCycleDay)) {
                    // 季末
                    if (DateUtil.isQuarterEnd(tranDate)) {
                        b = true;
                    }
                }
                break;
            case '5':
                // 半年结
                if ("1".equals(stlCycleDay)) {
                    // 半年初
                    if (DateUtil.isHalfYearBegin(tranDate)) {
                        b = true;
                    }
                } else if ("0".equals(stlCycleDay)) {
                    // 半年末
                    if (DateUtil.isHalfYearEnd(tranDate)) {
                        b = true;
                    }
                }
                break;
            case '6':
                // 年结
                if ("1".equals(stlCycleDay)) {
                    // 年初
                    if (DateUtil.isYearBegin(tranDate)) {
                        b = true;
                    }
                } else if ("0".equals(stlCycleDay)) {
                    // 年末
                    if (DateUtil.isYearEnd(tranDate)) {
                        b = true;
                    }
                }
                break;
            default:
                break;
        }
        return b;
    }


    // 比较频繁交易前后两笔的时间间隔与指定的某个时间对比，在这个时间段内，是频繁交易
    public static boolean monFreCompare(Date startTime, Date endTime, int interTime) {
        boolean flag = false;
        long a = (endTime.getTime() - startTime.getTime());
        // 两笔交易的时间间隔<=interTime,是频繁交易
        long interval = a / 1000;
        if (interval <= interTime && interval > 0) {
            flag = true;
        }

        return flag;
    }


    /**
     * 比较两个日期是否为同一天
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static boolean judgeDate(Date firstDate, Date secondDate) {
        Calendar calFirst = Calendar.getInstance();
        calFirst.setTime(firstDate);

        Calendar calSecond = Calendar.getInstance();
        calSecond.setTime(secondDate);

        if (calFirst.compareTo(calSecond) == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取区间为半小时的数据
     *
     * @param diff
     * @param minute
     * @return
     */
    public static final String getDiffDateTime(int diff, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, diff);
        c.add(Calendar.MINUTE, minute);

        return getFormat(dtLong).format(c.getTime());
    }


    /**
     * 获取格式
     *
     * @param format
     * @return
     */
    public static final DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }


    // 获取两个时间之间相差的天数
    public static int betweenDays(Date nowDate, Date LastLogpwdModifytime) {
        int result = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(df.parse(df.format(nowDate)));
            long time1 = cal.getTimeInMillis();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(df1.parse(df1.format(LastLogpwdModifytime)));
            long time2 = cal1.getTimeInMillis();
            result = Integer.parseInt(String.valueOf((time1 - time2) / (1000 * 60 * 60 * 24)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 比较两个时间的差值（以分钟统计）
     *
     * @param postDate
     * @param preDate
     * @return
     */
    public static long betweenTimes(Date postDate, Date preDate) {
        long minute = 0;
        long subTime = postDate.getTime() - preDate.getTime();
        if (subTime >= 0) {
            minute = MoneyUtil.divide(new BigDecimal(subTime), new BigDecimal(1000), null, null).longValue();
        }
        return minute;
    }


    /**
     * 根据查询范围，获取当日前范围日期
     *
     * @param date
     * @param dateScope
     * @return
     */
    public static Date getScopeDate(Date date, String dateScope) {
        Calendar sysdateCal = Calendar.getInstance();
        sysdateCal.setTime(date);
        if (Constants_comm.QUERY_SCOPE_WEEK.equals(dateScope)) {
            sysdateCal.add(Calendar.WEEK_OF_MONTH, -1);
        } else if (Constants_comm.QUERY_SCOPE_MONTH.equals(dateScope)) {
            sysdateCal.add(Calendar.MONTH, -1);
        } else if (Constants_comm.QUERY_SCOPE_THDMONTH.equals(dateScope)) {
            sysdateCal.add(Calendar.MONTH, -3);
        } else if (Constants_comm.QUERY_SCOPE_FIVE.equals(dateScope)) {
            sysdateCal.add(Calendar.MONTH, -6);
        }
        return sysdateCal.getTime();
    }


    /**
     * 获取当前明确时间
     *
     * @param date
     * @param dateFlag 1：起点时间 2：终点时间
     * @return
     */
    public static Date getRealTime(Date date, String dateFlag) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (Constants_comm.PRE_TIME.equals(dateFlag)) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        }

        return calendar.getTime();

    }


    /**
     * 获取当前明确日期
     *
     * @param date
     * @param dateFlag 1:月初 2：月末
     * @return
     */
    public static Date getRealMonth(Date date, String dateFlag) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (Constants_comm.PRE_TIME.equals(dateFlag)) {
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        }

        return calendar.getTime();

    }


    /**
     * @param term
     * @param dateStart
     * @param dateEnd
     * @return
     * @descrption 根据时间单位判断两个时间的单位差值
     */
    public static Integer betweenUnit(int term, Date dateStart, Date dateEnd) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(dateEnd);
        // if (isMonthEnd(dateEnd)) {
        // calendarStart.set(Calendar.DAY_OF_MONTH,
        // calendarEnd.get(Calendar.DAY_OF_MONTH));
        // }
        long termCount = 0;
        long yearSection = calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR);
        long monthSection = calendarEnd.get(Calendar.MONTH) - calendarStart.get(Calendar.MONTH);
        long daySection = calendarEnd.get(Calendar.DAY_OF_MONTH) - calendarStart.get(Calendar.DAY_OF_MONTH);
        if (Calendar.YEAR == term) {
            if (monthSection < 0) {
                yearSection -= 1;
            } else if (monthSection == 0) {
                if (daySection < 0) {
                    yearSection -= 1;
                }
            }
            termCount = yearSection;
        } else if (Calendar.MONTH == term) {

            termCount =
                    calendarEnd.get(Calendar.MONTH) + yearSection * 12 - calendarStart.get(Calendar.MONTH);
            if (daySection < 0) {
                termCount -= 1;
            }

        } else if (Calendar.DAY_OF_MONTH == term) {
            long secondStart = calendarStart.getTimeInMillis();
            long secondEnd = calendarEnd.getTimeInMillis();
            long secondDiffer = secondEnd - secondStart;
            termCount = secondDiffer / (1000 * 24 * 60 * 60);

        }
        return Integer.valueOf(String.valueOf(termCount));
    }


    /**
     * 计算起始日期和终止日期间排除前N个期限周期后的天数
     *
     * @param termUnit
     * @param term
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static Integer getRemianDays(int termUnit, Integer term, Date dateStart, Date dateEnd) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(dateStart);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(dateEnd);
        calendarStart.add(termUnit, term);

        return betweenUnit(Calendar.DAY_OF_MONTH, calendarStart.getTime(), dateEnd);
    }


    /**
     * 获取几天后时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getDateAfter(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
        return calendar.getTime();
    }

    /**
     * 获取几天后时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getDateAfter(Date date, long day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (int) (calendar.get(Calendar.DATE) + day));
        return calendar.getTime();
    }

    /**
     * 计算两个日期间相差的天数-360方式
     *
     * @param date
     * @param compareDate
     * @return
     * @throws ParseException
     */
    public static long compare360To(Date date, Date compareDate) {
        // 去掉时分秒
        date = parse(format(date, "yyMMdd"), "yyMMdd");
        compareDate = parse(format(compareDate, "yyMMdd"), "yyMMdd");

        //
        Calendar cDate = Calendar.getInstance();
        cDate.setTime(date);
        Calendar dDate = Calendar.getInstance();
        dDate.setTime(compareDate);

        int year = cDate.get(Calendar.YEAR) - dDate.get(Calendar.YEAR);
        int month = cDate.get(Calendar.MONTH) - dDate.get(Calendar.MONTH);
        int day = cDate.get(Calendar.DAY_OF_MONTH) - dDate.get(Calendar.DAY_OF_MONTH);
        //
        long a = year * 360 + month * 30 + day;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime());
        System.out.println(DateUtil.parse(DateUtil.format(DateUtil.getCurrentTime(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
    }
}
