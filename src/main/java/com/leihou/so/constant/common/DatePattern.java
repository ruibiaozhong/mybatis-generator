package com.leihou.so.constant.common;

/**
 * 类名: DatePattern</br> 
 * 包名：com.freegou.constant </br> 
 * 描述: 时间日期格式常量</br>
 * 发布版本号：</br>
 * 开发人员： ruibiaozhong</br>
 * 创建时间： 2016年6月1日
 */
public enum DatePattern {


    /**
	 *  yyyy-MM-dd HH:mm:ss
	 */
	LONG_DASH ("yyyy-MM-dd HH:mm:ss"),
	
	/**
	 *  yyyy-MM-dd HH:mm
	 */
	MID_DASH ("yyyy-MM-dd HH:mm"),
	
	/**
	 *  yyyy-MM-dd
	 */
	SHORT_DASH("yyyy-MM-dd"),
	
	/**
	 * yyyyMMdd
	 */
	SHORT ("yyyyMMdd"),
	
	/**
	 * yyMMdd
	 */
	ORDER_NO_TIME ("yyMMdd"),
	
	/**
	 *  yyyyMMddHHmmssSSS
	 */
	LONGEST_DASH ("yyyyMMddHHmmssSSS"),
	
	/**
	 * MMddHHmmssSSS
	 */
	LONGEST_DASH_WITHOUT_YEAR ("MMddHHmmssSSS"),
	
	/**
	 * HH:mm
	 */
	HOUR_SEC_COLON("HH:mm"),
	
	/**
	 * MM.dd
	 */
	MONTH_DAY_DOT("MM.dd"),
	
	/**
	 * yyyyMMddHHmmss
	 */
	WX_TIME_DASH("yyyyMMddHHmmss"),
	
	
	/**
	 * yyyy-MM
	 */
	YEAR_MONTH("yyyy-MM"),

	COMMON("yyyy/MM/dd"),

	RECHARGE_NO("yyMMdd"),

	TRANSACTION_NO("ddHHmmssSSS"),
	
	/**
	 * yyyyMM
	 */
	YYYYMM("yyyyMM"), 
	
	YYYY("yyyy")
	;
	
	

	private String format; 
	
	
	private DatePattern(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return format;
	}
}
