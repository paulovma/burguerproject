package br.com.entelgy.burguerproject.exception;

public class AuthorizeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public AuthorizeException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
