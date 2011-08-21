package blue.liuk.exception;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author liuk
 * @version 0.0.1
 */
public class ExceptionMsg {
	static Logger mylog = Logger.getLogger(ExceptionMsg.class);
	private static Document doc = null;
	// 默认显示中文
	public static String local = "zh_cn";
	// 根据key获取异常说明文本
	public static String getMsg(String key) {
		SAXReader sr = new SAXReader();
		try {
			doc = sr.read(ExceptionMsg.class
					.getResourceAsStream("/errormessage.xml"));
		} catch (DocumentException e) {
			throw new HrException("errormessage.xml ERROR", e);
		}
		Element msgelement = doc.getRootElement();
		String localtemp = msgelement.element("local").getText();
		local = (null == localtemp) ? local : localtemp;
		// mylog.info("指定语言为：" + local);
		Element msgsElement = msgelement.element(local);
		// mylog.info("指定KEY为：" + key);
		String string = msgsElement.elementText(key);
		// mylog.info("找到msg为：" + string);
		return string;
	}
}
