/**
 * 
 */
package blue.liuk.exception;

/**
 * @author liuk
 *
 */
public interface  ErrorMsg {
	
	/**
	 * 没有指定的搜索结果
	 */
	String NO_RESULT="noresult";
	
	/**
	 * 保存错误
	 */
	String SAVE_ERROR="saveerror";
	
	/**
	 * 删除错误
	 */
	String DELETE_ERROR="idcandelete";
	
	/**
	 * 指定ID搜索结果为空
	 */
	String	ID_FIND_NO="idfindno";
	/**
	 * 用户名重复
	 */
	String	USER_NAME_DUPLICATE="usernamedu";
	/**
	 * 角色名重复
	 */
	String	ROLe_NAME_DUPLICATE="rolenamedu";
	/**
	 * 根据id用户搜索不到
	 */
	String	ID_USER_FIND_NO="useridfindno";
	
	/**
	 * 部门删除错误，该部门仍有员工
	 */
	String DELETE_ERROR_HAVE_EMS="delerrorhasems";
	/**
	 *部门名称重复
	 */
	String DEPT_NAME_REPEAT_ERROE="deptnamerepeat";
	/**
	 *权限提示
	 */
	String NO_ACCESS="noaccess";
	
	/**
	 *录用但没审核
	 */
	String NO_CHECK="nocheck";
	
	/**
	 *ID为空
	 */
	String ID_IS_NULL="idisnull";
	
	/**
	 *管理员不能删除
	 */
	String ADMIN_SYSTEM_DELETE="sysadmindelete";
	/**
	 *管理员不能编辑此项
	 */
	String ADMIN_SYSTEM_EDIT="sysadminedit";
	/**
	 *仍有用户包含此角色
	 */
	String ROLE_HAVE_USERS="rolehaveusers";
	/**
	 *y用户被禁用
	 */
	String USER_IS_DISABLE="useriddisable";
	
	
	
}

