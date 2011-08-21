package blue.liuk.extra;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blue.liuk.exception.AccessException;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.exception.HrException;
import blue.liuk.model.Role;
import blue.liuk.model.User;
import blue.liuk.util.GetSth;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author liuk SystemIn 权限控制 lv：权限等级
 * 
 */
@Component
public class SystemIn extends AbstractInterceptor {
	Log logger = LogFactory.getLog(SystemIn.class);
	private static final long serialVersionUID = 8642568944126250891L;
	@Autowired
	private EEManage eeManage;
	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session =ai.getInvocationContext().getSession();
		logger.info(eeManage.getAll());
		logger.info(ai.getAction());
		logger.info(ai.getProxy().getActionName());
		logger.info(ai.getProxy().getMethod());
		logger.info(ai.getProxy().getNamespace());
		logger.info(ai.getProxy().getAction());
		User user = (User) session.get("user");
		
		//2011年5月27日 02:16:44
	//	if (null == user.getEnable() || user.getEnable().intValue() < 1) {
		//	throw new HrException(ErrorMsg.USER_IS_DISABLE);
	//	}
		// 系统内置管理员
		//可以访问所有的资源
		
		if (user.getId() == 1) {
			logger.info("管理员登陆"+user.getUsername()+new Date());
			return ai.invoke();
		}
		String resname = getRes(ai);
		//不是受限资源
		if (eeManage.getRes(resname).size()==0) {
			return ai.invoke();
		}	
		List<Role> lsit1 = eeManage.getRoleByUser(user.getUsername());
		logger.info(user.getUsername()+"访问"+resname+new Date());
		List<Role> lsit2 = eeManage.getRoleByRes(resname);
		if (!checkRole(lsit1, lsit2)) {
			throw new AccessException(ErrorMsg.NO_ACCESS);
		}
		return ai.invoke();
	}
	public boolean checkRole(List<Role> l1, List<Role> l2) {

		for (Role role : l2) {
			if (l1.contains(role)) {
				return true;
			}
		}
		return false;
	}
	public String getRes(ActionInvocation ai) {
		String actionname =ai.getAction().toString();
		String type = ai.getProxy().getMethod();
		int i = actionname.indexOf("@");
		int j = actionname.lastIndexOf(".")+1;
		actionname = actionname.substring(j,i);
		System.out.println(type);
		return actionname+type;
	}
}
