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
public class SystemIn extends AbstractInterceptor {

	Log logger=LogFactory.getLog(SystemIn.class);
	private static final long serialVersionUID = 8642568944126250891L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session=ai.getInvocationContext().getSession();
		String username=(String) session.get("username");
		String lv=(String) session.get("le");
		if (null!=username&&null!=lv&&Integer.parseInt(lv)>=4) {
			logger.info("1权限控制1");
			String rsString=	ai.invoke();
			logger.info("1权限控制2"+rsString);
			return rsString;
		}
//		if (null!=username) {
//		return ai.invoke();
//	}
		else {
			session.put("systip","没有权限，请登录后操作  "+new Date());
			return "login";

		}
		
	}

}
