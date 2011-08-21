package blue.liuk.extra;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blue.liuk.exception.AccessException;
import blue.liuk.exception.ErrorMsg;
import blue.liuk.model.Role;
import blue.liuk.model.User;

import com.opensymphony.xwork2.ActionContext;

@Service
@Aspect
public class Permition {
	@Autowired
	private EEManage eeManage;

	@Pointcut("execution(* blue.liuk.action.*.*(..))")
	public void check() {}

	@Before("check()")
	public void doCheck(JoinPoint ja) {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		// 系统内置管理员
		if (user.getId() == 1) {
			return;
		}
		List<Role> lsit1 = eeManage.getRoleByUser(user.getUsername());
		String resname = getRes(ja);
		List<Role> lsit2 = eeManage.getRoleByRes(resname);
		if (!checkRole(lsit1, lsit2)) {
			throw new AccessException(ErrorMsg.NO_ACCESS);
		}
	}

	public boolean checkRole(List<Role> l1, List<Role> l2) {

		for (Role role : l2) {
			if (l1.contains(role)) {
				return true;

			}
		}
		return false;

	}

	public String getRes(JoinPoint ja) {

		String methname = ja.getSignature().getName();
		String type = ja.getSignature().getDeclaringTypeName();
		int i = type.lastIndexOf(".") + 1;
		type = type.substring(i, type.length());
		System.out.println(type);
		return type + methname;

	}

}
