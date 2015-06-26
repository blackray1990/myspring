package com.hjs.study.spring.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

 // part one get year moth day ..........

 /**
  * 返回年份
  * 
  * @param date
  *            日期
  * @return 返回年份
  */
 public static int getYear(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.YEAR);
 }

 /**
  * 返回月份
  * 
  * @param date
  *            日期
  * @return 返回月份
  */
 public static int getMonth(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.MONTH) + 1;
 }

 /**
  * 返回日份
  * 
  * @param date
  *            日期
  * @return 返回日份
  */
 public static int getDay(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.DAY_OF_MONTH);
 }

 /**
  * 返回年份
  * 
  * @param date
  *            日期
  * @return 返回年份
  */
 public static Date setYear(Date date, int year) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.set(Calendar.YEAR, year);
  return c.getTime();
 }

 /**
  * 返回月份
  * 
  * @param date
  *            日期
  * @return 返回月份
  */
 public static Date setMonth(Date date, int month) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.set(Calendar.MONTH, month);
  return c.getTime();
 }

 /**
  * 返回日份
  * 
  * @param date
  *            日期
  * @return 返回日份
  */
 public static Date setDay(Date date, int day) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.set(Calendar.DAY_OF_MONTH, day);
  return c.getTime();
 }

 /**
  * 返回小时
  * 
  * @param date
  *            日期
  * @return 返回小时
  */
 public static int getHour(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.HOUR_OF_DAY);
 }

 /**
  * 返回分钟
  * 
  * @param date
  *            日期
  * @return 返回分钟
  */
 public static int getMinute(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.MINUTE);
 }

 /**
  * 返回秒钟
  * 
  * @param date
  *            日期
  * @return 返回秒钟
  */
 public static int getSecond(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.SECOND);
 }

 /**
  * 返回毫秒
  * 
  * @param date
  *            日期
  * @return 返回毫秒
  */
 public static long getMillis(Date date) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.getTimeInMillis();
 }

 // part two math for date

 /**
  * 日期加年
  * 
  * @param date*
  *            日期
  * @param int*
  *            年
  * @return 相加后日期
  */
 public static Date addYear(Date date, int year) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.YEAR, year);
  return c.getTime();
 }

 public static Date addYear(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return addYear(date, c.get(Calendar.YEAR));
 }

 /**
  * 日期加月
  * 
  * @param date*
  *            日期
  * @param int*
  *            月
  * @return 相加后日期
  */
 public static Date addMonth(Date date, int month) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.MONTH, month);
  return c.getTime();
 }

 public static Date addMonth(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return addYear(date, c.get(Calendar.MONTH));
 }

 /**
  * 日期加天
  * 
  * @param date*
  *            日期
  * @param int*
  *            天
  * @return 相加后日期
  */
 public static Date addDay(Date date, int day) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.DAY_OF_YEAR, day);
  return c.getTime();
 }

 public static Date addDay(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return addYear(date, c.get(Calendar.DAY_OF_YEAR));
 }

 public static Date subYear(Date date, int year) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.YEAR, -year);
  return c.getTime();
 }

 public static Date subYear(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return subYear(date, c.get(Calendar.YEAR));
 }

 /**
  * 日期加月
  * 
  * @param date*
  *            日期
  * @param int*
  *            月
  * @return 相加后日期
  */
 public static Date subMonth(Date date, int month) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.MONTH, -month);
  return c.getTime();
 }

 public static Date subMonth(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return subMonth(date, c.get(Calendar.YEAR));
 }

 /**
  * 日期加天
  * 
  * @param date*
  *            日期
  * @param int*
  *            天
  * @return 相加后日期
  */
 public static Date subDay(Date date, int day) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  c.add(Calendar.DAY_OF_YEAR, -day);
  return c.getTime();
 }

 public static Date subDay(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return subDay(date, c.get(Calendar.YEAR));
 }

 public static int gapYear(Date date, int year) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.YEAR) - year;
 }

 public static int gapYear(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return sumYear(date, c.get(Calendar.YEAR));
 }

 public static int gapMonth(Date date, int month) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.MONTH) - month;
 }

 public static int gapMonth(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return gapMonth(date, c.get(Calendar.MONTH));
 }

 public static int gapDay(Date date, int day) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.DAY_OF_YEAR) - day;
 }

 public static int gapDay(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return sumDay(date, c.get(Calendar.DAY_OF_YEAR));
 }

 public static int sumYear(Date date, int year) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.YEAR) + year;
 }

 public static int sumYear(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return sumYear(date, c.get(Calendar.YEAR));
 }

 public static int sumMonth(Date date, int month) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.MONTH) + month;
 }

 public static int sumMonth(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return sumMonth(date, c.get(Calendar.MONTH));
 }

 public static int sumDay(Date date, int day) {
  Calendar c = Calendar.getInstance();
  c.setTime(date);
  return c.get(Calendar.DAY_OF_YEAR) + day;
 }

 public static int sumDay(Date date, Date date1) {
  Calendar c = Calendar.getInstance();
  c.setTime(date1);
  return sumDay(date, c.get(Calendar.DAY_OF_YEAR));
 }

 // 日期转换
 public static Date parseToDate(String src, String format) {

  Date date = null;
  DateFormat dateFormat = new SimpleDateFormat(format);
  try {
   date = dateFormat.parse(src);
  } catch (ParseException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return date;
 }

 public static Date parseToDate(String src) {

  return parseToDate(src, "yyyy-MM-dd");
 }

 // 日期转换
 public static String parseToString(Date date, String format) {

  DateFormat dateFormat = new SimpleDateFormat(format);
  return dateFormat.format(date);

 }

 public static String parseToString(Date date) {
  return parseToString(date, "yyyy-MM-dd");
 }

 public static String parseYMString(Date date) {
  return parseToString(date, "yyyyMM");
 }

 /*
  * 涉及到指标计算的日期函数 根据逻辑月和日计算汇总开始和结束日期
  */

 public static String operatorDate(Date calcDate, int logicMonth,
   int logicDay) {
  Date operatorDate = calcDate;
  // operatorDate.
  Calendar cal = Calendar.getInstance();
  cal.setTime(operatorDate);
  cal.add(Calendar.MONTH, logicMonth);
  cal.set(Calendar.DAY_OF_MONTH, logicDay);
  return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

 }

 public static void main(String[] args) {

  System.out.println("add++");
  System.out.println("" + addYear(new Date(), 3));
  System.out.println("" + addMonth(new Date(), 3));
  System.out.println("" + addDay(new Date(), 3));

  System.out.println("roll--");
  System.out.println("" + subYear(new Date(), 3));
  System.out.println("" + subMonth(new Date(), 3));
  System.out.println("" + subDay(new Date(), 3));
  System.out.println("parseDate-----");
  System.out.println("" + parseToDate("2005-11-12"));
  System.out.println("" + parseToDate("2005-01-04", "yyyy-MM-dd"));
  System.out.println("parseString-----");
  System.out.println("" + parseToString(new Date(), "yyyy-MM-dd"));
  System.out.println("" + parseToString(new Date()));
  System.out.println("operatorDate:"
    + operatorDate(parseToDate("2006-12-1"), 1, 26));

 }

 public static String getYM(String InputDate) throws Exception {

  // 判断输入的日期中是否有"-"
  if (InputDate.indexOf("-") <= 0)
   throw new Exception("日期[" + InputDate + "]格式输入错误!");

  // 拆分年和月
  String[] arrMonth = InputDate.trim().split("-");

  String year = arrMonth[0];
  String month = arrMonth[1];

  // 判断年是否为标准的4位输入，月份是否大于0，小于13
  if ((year.length() != 4) || (Integer.parseInt(month) > 12)
    || (Integer.parseInt(month) < 1))
   throw new Exception("日期[" + InputDate + "]格式输入错误!");

  // 如果月是输入一位则补在前面补0
  if (month.length() == 1)
   month = "0" + month;

  return year + "-" + month;
 }

 /**
  * 获得月最大日期，即为月最后一天
  * 
  * @param calcdate
  * @return
  * @throws ParseException
  */
 public static String getMaxDate(String calcdate) throws ParseException {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  Calendar date = Calendar.getInstance();
  date.setTime(sdf.parse(calcdate));
  date.set(Calendar.DAY_OF_MONTH, date.getMaximum(Calendar.DAY_OF_MONTH));// 设置为月末
  String max_date = sdf.format(date.getTime());
  System.out.println("max_date = " + max_date);
  return max_date;
 }

 /**
  * 获得次月1日日期
  * 
  * @param calcdate
  * @return
  * @throws ParseException
  */
 public static String getMinDate(String calcdate) throws ParseException {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  Calendar date = Calendar.getInstance();
  date.setTime(sdf.parse(calcdate));
  date.add(Calendar.MONTH, 1);// 设置月为下个月
  date.set(Calendar.DAY_OF_MONTH, date.getMinimum(Calendar.DAY_OF_MONTH));// 设置日为月第一天
  String min_date = sdf.format(date.getTime());
  System.out.println("min_date = " + min_date);
  return min_date;
 }

 /**
  * @param Enddate
  * @param Startdate
  * @return
  * @throws Exception
  *             判断开始时间是否大于结束时间。
  */
 public static boolean isEnddateAfterStartdate(String Startdate,
   String Enddate) throws Exception {
  boolean flag = false;
  Enddate = Enddate.trim();
  Startdate = Startdate.trim();
  try {
   if (java.sql.Date.valueOf(Startdate).after(
     java.sql.Date.valueOf(Enddate))) {
    flag = false;
   } else {
    flag = true;
   }
  } catch (Exception e) {
   throw new Exception("结束日期不能大于起始日期！");
  } finally {
   return flag;
  }

 }
}