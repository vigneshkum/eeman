package blue.liuk.base;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import blue.liuk.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author liuk
 *
 */
public class BaseAction {
	public static String  SUCCESS="success";
    /**
	 * 
	 */
	private static final long serialVersionUID = 8600381040800125520L;
	/**
      * 获得当前Session
      * 
     */
    @SuppressWarnings("rawtypes")
	public Map getSession() {
        return ActionContext.getContext().getSession();
     }

 

    /**
      * 根据指定的页面参数名称，获取页面传递来的参数值
      * 
      * @param parameter
      * @return 数组对象
     */
    protected Object[] getParamenterArray(String parameter) {
        return (Object[]) (ActionContext.getContext().getParameters()
                 .get(parameter));
     }


    /**
      * 从session中取得相应的值
      * 
      * @param key
      * @return
     */
    public Object getSessionObj(Object key) {
        return getSession().get(key);
     }
    /**
     * 设置session的值
    */

     @SuppressWarnings("unchecked")
    public void setSessionObj(Object key,Object value){
         getSession().put(key, value);
     }
     /**
      * response输出
      * 
     */
     public void sendMsg(String content) throws IOException {
 		HttpServletResponse response = ServletActionContext.getResponse();
 		response.setCharacterEncoding("UTF-8");
 		response.getWriter().write(content);
 	}
     
     /**
      * 获取登陆的用户
     * @return User
     */
    public User getUser(){
    	 User user=(User) getSessionObj("user");
    	 return user;
    	 
     }
}
