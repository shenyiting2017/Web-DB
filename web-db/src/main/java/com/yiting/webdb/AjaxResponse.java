package com.yiting.webdb;

import java.io.Serializable;
import java.util.HashMap;

public class AjaxResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	private final HashMap<String, Object> data = new HashMap<String, Object>();
	private String status;
	
	public static AjaxResponse successResponse() {
		AjaxResponse response = new AjaxResponse();
		response.status = AjaxResponse.SUCCESS;
		return response;
	}
	
	public static AjaxResponse errorResponse() {
		AjaxResponse response = new AjaxResponse();
		response.status = AjaxResponse.ERROR;
		return response;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void putData(String key, Object value) {
		this.data.put(key, value);
	}
}
