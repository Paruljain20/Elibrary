package com.app.elib.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class Response {
	@JsonView
	String msg;
	
	@JsonView
	String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Response(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}

	public Response(String code) {
		super();
		this.code = code;
	}
	
}
