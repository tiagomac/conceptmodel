package com.tiagomac.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
