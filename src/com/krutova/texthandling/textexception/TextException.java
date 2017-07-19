package com.krutova.texthandling.textexception;

public class TextException  extends Exception {

	private static final long serialVersionUID = 6490489880150893407L;

	public TextException() {
	}
	
	public TextException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextException(String message) {
		super(message);
	}

	public TextException(Throwable cause) {
		super(cause);
	}
}
