package com.softfactory.core.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取下一个编号值得工具类
 * */
public class ErpUtils {
	/**
	 * 格式化时间对象
	 * */
	public static String toString(Date date) {
		SimpleDateFormat p = new SimpleDateFormat("yyyyMMdd");
		return p.format(date);
	}

	/**
	 * 格式化数值对象
	 * */
	public static String goString(long str) {
		NumberFormat n = new DecimalFormat("0000");
		return n.format(str);
	}
	
	/**
	 * 格式化数值对象(产品编号)
	 * */
	public static String goStringl(long str) {
		NumberFormat n = new DecimalFormat("000000");
		return n.format(str);
	}

	/**
	 * @param prefix 不同对象对于的前缀
	 * @param num为查询相应对象的max(编号值)
	 * @return 新的编号值
	 * */
	public static String getNumber(String prefix,String num) {
		if(null!=num&&!"".equals(num)){
			String date = toString(new Date());
			String date1 = date.substring(0, 4);
			String str1 = num.substring(0, 3);
			String str2 = num.substring(3, 7);
			String str3 = num.substring(11);
			if (!date1.equals(str2)) {
				return str1 + date + "0001";
			} else {
				long l = Long.parseLong(str3) + 1;
				String str4 = goString(l);
				return str1 + date + str4;
			}
		}else{
			return prefix+toString(new Date())+"0001";
		}
		
	}

}
