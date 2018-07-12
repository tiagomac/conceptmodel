package com.tiagomac.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timeStamp;
	private String exception;

	public StandardError(Integer status, String msg, Long timeStamp, String exception) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
		this.exception = exception;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}
