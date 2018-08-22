package com.tiagomac.services.exceptions;

public class FileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileException(String msg) {
		super(msg);
	}

	public FileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
