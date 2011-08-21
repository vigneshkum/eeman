package blue.liuk.extra;

import javax.servlet.http.HttpServletRequest;

import blue.liuk.model.User;

public interface CheckUser {

	User doCheck(HttpServletRequest request);

}
