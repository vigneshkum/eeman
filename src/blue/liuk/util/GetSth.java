package blue.liuk.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 工具
 * 
 * @author liuk
 */
public class GetSth {
	static Log logger = LogFactory.getLog(GetSth.class);

	/**
	 * 计算年龄
	 * 
	 * @param date
	 *            输入的日期，当前日期减去此日期为年龄
	 * @return int
	 */
	public static int getAge(Date date) {
		// logger.info(date);
		int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(fDate(date, "yyyy-MM-dd").substring(0, 4));
		return age > 0 ? age : 0;
	}

	/**
	 * 计算出生年份
	 * 
	 * @param age
	 *            要计算的年龄
	 * @return String
	 */
	public static String getDate(int age) {
		int thisy = Calendar.getInstance().get(Calendar.YEAR);
		int birth = thisy - age;
		Date mydateDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		try {
			// logger.info(birth);
			mydateDate = sdf.parse(String.valueOf(birth));
			// logger.info(GetSth.fDate(mydateDate,"yyyy"));
		}
		catch (ParseException e) {

			// e.printStackTrace();
		}
		return GetSth.fDate(mydateDate, "yyyy");
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @param fs
	 *            输入需要的格式
	 * @return String
	 */
	public static String fDate(Date date, String fs) {
		SimpleDateFormat sdf = new SimpleDateFormat(fs);
		// logger.info(sdf.format(date));
		return sdf.format(date);
	}

	/**
	 * string编码转换 由ISO-8859-1到 UTF-8
	 * 
	 * @param s
	 *            需要转换的string
	 * @return String
	 */
	public static String change(String s) {
		String ss = null;
		try {
			ss = new String(s.getBytes("ISO-8859-1"), "UTF-8");
		}
		catch (UnsupportedEncodingException e) {

			// e.printStackTrace();
			// 转换失败返回原数据
			ss = s;
		}
		return ss;
	}

	/**
	 * String 到Date
	 * 
	 * @param date
	 *            日期字符串
	 * @return Date
	 */
	public static Date getNewDate(String date, String s) {
		Date mydateDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat(s);
		try {
			// logger.info(birth);
			mydateDate = sdf.parse(date);

			// logger.info(GetSth.fDate(mydateDate,"yyyy"));
		}
		catch (ParseException e) {

			// e.printStackTrace();

		}
		return mydateDate;
	}

	public static String getMd5(String s) {

		return null;
	}

	// public static void main(String[] dddStrings ){
	//
	// System.out.print(GetSth.getDate(10));
	// System.out.print(getAge(new Date()));
	//
	// }
}
