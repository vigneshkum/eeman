package blue.liuk.extra;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blue.liuk.model.User;



/**
 * LoginFilter <br />
 * Servlet Filter 过滤器，此过滤器使用Spring管理<br />
 * 过滤所有url，判断登陆url和注销url后转到相应处理<br />
 * 没有用户登陆，将阻止所有URL，跳转到登录页面<br />
 * @author liuk
 * @since 0.1 2011年5月21日 23:04:43
 */
@Component
public class LoginFilter implements Filter {
	/**
	 * 登陆和注销的url
	 */
	private   String loginUrl="/login_check";
	private   String logoutUrl="/logout_check";
	@Autowired
	private  CheckUser checkUser;
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * 主要实现
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		
		if (null==session.getAttribute("user")) {
			if (checkUrl(req, loginUrl)) {
					User user=checkUser.doCheck(req);
					if (null!=user) {
							if ((null == user.getEnable() || user.getEnable().intValue() < 1)&&user.getId()!=1) {
								//用户被禁用
								//sj
								req.getRequestDispatcher("/login.jsp?error=10").forward(req, resp);
								return;
							}else {
								session.setAttribute("user", user);
								//session.setAttribute("roles", user.getRoles());
								session.setAttribute("username", user.getUsername());
							//	chain.doFilter(request, response);
								req.getRequestDispatcher("/login.jsp?error=4").forward(req, resp);
							//	resp.sendRedirect("index.jsp");
							}
						
					}else {
						//登陆失败
						req.getRequestDispatcher("/login.jsp?error=0").forward(req, resp);
						
						return;
					}
					
				}else {
					//需要登陆
					req.getRequestDispatcher("/login.jsp?error=1").forward(req, resp);
					return;
				}
		}
		//重复登陆
		else if (checkUrl(req, loginUrl)) {
			
			req.getRequestDispatcher("/login.jsp?error=2").forward(req, resp);
			return;
		//安全退出
		} else if(checkUrl(req, logoutUrl)) {
			session.removeAttribute("user");
			session.removeAttribute("username");
			session.invalidate();
			req.getRequestDispatcher("/login.jsp?error=3").forward(req, resp);
			return;
		}
		else{
			chain.doFilter(request, response);
			//return;
		}
	}
	/**
	 * 是否登陆的url判断
	 */
	 private boolean checkUrl(HttpServletRequest request,String url) {
	        String uri = request.getRequestURI();
	        int pathParamIndex = uri.indexOf(';');

	        if (pathParamIndex > 0) {
	            uri = uri.substring(0, pathParamIndex);
	        }

	        if ("".equals(request.getContextPath())) {
	            return uri.endsWith(url);
	        }

	        return uri.endsWith(request.getContextPath() + url);
	    }
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
