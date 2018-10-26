package com.leihou.so.util;


import com.leihou.so.constant.common.DatePattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;

import java.util.*;

/**
 * 日期辅助类
 * 类名: DateUtils</br> 
 * 包名：com.freegou.djStore.util </br> 
 * 描述: </br>
 * 发布版本号：</br>
 * 开发人员： ruibiaozhong</br>
 * 创建时间： 2016年10月17日
 */
public class DateUtils {

	/**
	 * 格式化日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
     * 方法名: format</br>
	 * 详述: 格式化日期</br>
	 * 开发人员：ruibiaozhong</br>
	 * 创建时间：2016年6月1日</br>
	 * 
	 * @param date
	 *            Date类型的日期
	 * @param datePattern
	 *            日期的格式 在类DatePattern里面有定义
	 * @return
	 */
	public static String format(Date date, DatePattern datePattern) {
		if (null == date) {
			return null;
		}

		return DateFormatUtils.format(date, datePattern.toString());
	}
	
	public static Date parse(String str, DatePattern pattern) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(str, pattern.toString());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	public static boolean isWorkday(Date date) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int sunday = 1;
		int saturday = 7;
		if (sunday == dayOfWeek || saturday == dayOfWeek) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * 方法名: add235959</br>
	 * 详述: 把时间增加23h59m59s</br>
	 * 开发人员：ruibiaozhong</br>
	 * 创建时间：2017年3月9日</br>
	 * @param date
	 * @return
	 */
	public static Date add235959(Date date) {
		if (null == date) {
			return null;
		}
		Date hourDate = org.apache.commons.lang3.time.DateUtils.addHours(date, 23);
		Date minDate = org.apache.commons.lang3.time.DateUtils.addMinutes(hourDate, 59);
		Date secondDate = org.apache.commons.lang3.time.DateUtils.addSeconds(minDate, 59);
		return secondDate;
	}

	/**
	 *
	 * 方法名: set235959</br>
	 * 详述: 把时间设置为23h59m59s</br>
	 * 开发人员：ruibiaozhong</br>
	 * 创建时间：2018年6月5日</br>
	 * @param date
	 * @return
	 */
	public static Date set235959(Date date) {
		if (null == date) {
			return null;
		}
		Date hourDate = org.apache.commons.lang3.time.DateUtils.setHours(date, 23);
		Date minDate = org.apache.commons.lang3.time.DateUtils.setMinutes(hourDate, 59);
		Date secondDate = org.apache.commons.lang3.time.DateUtils.setSeconds(minDate, 59);
		return secondDate;
	}

	/**
	 * 方法名: set000000</br>
	 * 详述: 把时间设置为00h00m00s</br>
	 * 开发人员：lvhao</br>
	 * 创建时间：2018年7月21日</br>
	 *
	 * @param date
	 * @return
	 */
	public static Date set000000(Date date) {
		if (null == date) {
			return null;
		}
		Date hourDate = org.apache.commons.lang3.time.DateUtils.setHours(date, 0);
		Date minDate = org.apache.commons.lang3.time.DateUtils.setMinutes(hourDate, 0);
		Date secondDate = org.apache.commons.lang3.time.DateUtils.setSeconds(minDate, 0);
		return secondDate;
	}
	
	/**
	 * 方法名: firstDate</br>
	 * 详述: 获取月份的第一天 </br>
	 * 开发人员：yuanbao</br>
	 * 创建时间：2017年3月13日</br>
	 * @param date
	 * @return
	 */
	public static Date firstDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		return c.getTime();
	}


	/**
	 * 方法名: endDate</br>
	 * 详述: 获取月份的最后一天 </br>
	 * 开发人员：yuanbao</br>
	 * 创建时间：2017年3月13日</br>
	 * @param date
	 * @return
	 */
	public static Date endDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.getTime();
	}

	/**
	 * 获取对应的时间以秒为单位
	 * @return
	 */
	public static Integer getTimeInSeconds() {
		Long second = Calendar.getInstance().getTimeInMillis() / 1000;
		return second.intValue();
	}
	
	
	public static Long getLongTimeInSecond() {
		Long second = Calendar.getInstance().getTimeInMillis() / 1000;
		return second;
	}

	public static Long dateToLongMilisecond(Date date) {
		if (null == date) {
			return null;
		}
		return date.getTime();
	}
	
	/**
	 * 把秒转换成时间
	 * @param seconds
	 * @return
	 */
	public static Date toDate(Integer seconds) {
		return new Date(seconds * 1000);
	}

	/**
	 * 获取当前的时间
	 * @return
	 */
	public static String getNow() {
		return format(new Date(), DatePattern.LONG_DASH);
	}
	



}














