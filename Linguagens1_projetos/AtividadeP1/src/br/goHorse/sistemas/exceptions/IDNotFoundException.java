package br.goHorse.sistemas.exceptions;

public class IDNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public IDNotFoundException() {
		super();
	}

	public IDNotFoundException(String msg) {
		super(msg);
	}
	public IDNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}