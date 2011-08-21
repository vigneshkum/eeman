package blue.liuk.util;

import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * @author liuk
 * SystemIn
 * 权限控制
 *   lv：权限等级
 * 
 */
public class SystemInMa extends AbstractInterceptor {

	Log logger=LogFactory.getLog(SystemInMa.class);
	private static final long serialVersionUID = 8642568944126250891L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session=ai.getInvocationContext().getSession();
		String username=(String) session.get("username");
		String lv=(String) session.get("le");
		if (null!=username&&null!=lv&&Integer.parseInt(lv)>=5) {
			logger.info("2权限控制1");
			String rsString=ai.invoke();
			logger.info("2权限控制2"+rsString);
			return rsString;
		}
		else {
			session.put("systip","权限不足，请使用系统管理员登录或者联系管理员后操作  "+GetSth.fDate(new Date(), "yyyy/MM/dd"));
			return "login";

		}
		
	}

}
