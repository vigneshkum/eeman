/**
 * 
 */
package blue.liuk.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import blue.liuk.util.GetSth;



/**
 * @author liuk
 */
public class ExceptionTest {
	
	@Test
	public void testdatefot() throws ParseException {
		Date ddDate=new Date();
		
	String string=GetSth.fDate(ddDate, "yyyy-MM-dd");
	System.out.println(string);
	SimpleDateFormat sdf = new SimpleDateFormat();
	
	int thisy= Calendar.getInstance().get(Calendar.YEAR);
	System.out.println(sdf.parse(String.valueOf(thisy)));
	System.out.println(GetSth.getDate(thisy));
	
//	Date d=GetSth.getNewDate("2010");
//	System.out.print(d);
	
}
	@Test
	public void name() {
		int thisy= Calendar.getInstance().get(Calendar.YEAR);
		Date mydateDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		//	logger.info(birth);	
			mydateDate=sdf.parse("1200-01-01");
			System.out.println(mydateDate);
		//	logger.info(GetSth.fDate(mydateDate,"yyyy"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}