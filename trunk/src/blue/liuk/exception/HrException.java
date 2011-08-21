package blue.liuk.exception;

/**
 * 业务逻辑异常类
 * @author liuk
 * @version 0.0.1
 */
public class HrException extends RuntimeException {
	private static final long serialVersionUID = 8820534132621362038L;

	public HrException()
	{
		super();

	}

	public HrException(String msg)
	{
		super(msg);

	}

	public HrException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public HrException(Throwable cause)
	{
		super(cause);
	}
	
	/* 
	 * 信息输出格式，通过错误代码获取错误信息
	 */
	public String toString() {
		String s = getClass().getName();
		String message =ExceptionMsg.getMsg( getLocalizedMessage());
		return (message != null) ? message : s;
	}
}
