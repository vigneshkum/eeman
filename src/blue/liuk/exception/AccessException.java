/**
 * 
 */
package blue.liuk.exception;

/**
 * 权限异常类
 * @author liuk
 * 
 */
public class AccessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1822541030922223843L;

	public AccessException()
	{
		super();
	}

	public AccessException(String msg)
	{
		super(msg);
	}

	public String toString() {
		String s = getClass().getName();
		String message = getLocalizedMessage();
		return (message != null) ? ExceptionMsg.getMsg(message) : s;
	}

}
