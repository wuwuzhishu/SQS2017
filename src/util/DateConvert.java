package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	//日期字符串(包括时分秒)转换为TimeStamp对象
	public static Timestamp stringToTimeStamp(String str){
		Timestamp ts=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			Date date=(Date) sdf.parse(str);
			ts = new Timestamp(date.getTime());			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;
	}
	//将Date型日期转换成指定格式的字符串形式，如“yyyy年MM月dd日 HH:mm:ss”
	public static String dateToString(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return sdf.format(date);		
	}
	//日期字符串转换为Date对象
	public static Date stringToDate(String str){
		Date date=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
			date=(Date) sdf.parse(str);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}	
	/*
	 * java.sql.Date是针对SQL语句使用的，它只包含日期而没有时间部分,
	 * 它们都有getTime方法返回毫秒数，自然就可以直接构建。 
	 * java.util.Date 是 java.sql.Date 的父类，
	 * 前者是常用的表示时间的类，我们通常格式化或者得到当前时间都是用前者，
	 * 后者在读写数据库的时候用他， 因为PreparedStament的setDate()的第2参数和
	 * ResultSet的getDate()方法的第2个参数都是java.sql.Date。
	*/	
	//把java.util.date转换为数据库中的Timestamp（java.sql.timestamp）
	public static Timestamp dateToTimestamp(java.util.Date date){
		return new java.sql.Timestamp(date.getTime());
	}
	//把java.util.date转换为数据库中的Date（java.sql.Date）
	public static java.sql.Date dateToSQLDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}	
	
	//把数据库中的Date(java.sql.date)转换为java.util.Date
	public static java.util.Date dateToUtilDate(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}	
	
}
