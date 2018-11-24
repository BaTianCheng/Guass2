package com.cw.guass2.dispatch.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 响应实体类
 * @author wicks
 *
 */
public class ResponseEntity implements Serializable{

	private static final long serialVersionUID = 7503198045296984787L;

	private String requestId;
	
	private String statusCode;
	
	private String message;
	
	private String subStatus;
	
	private String subMessage;
	
	private Object data;
	
	private long costTime;
	
	public ResponseEntity(RequestEntity requestEntity) {
		this.requestId = requestEntity.getRequestId();
		this.statusCode = requestEntity.getStatusCode();
		this.message = requestEntity.getMessage();
		this.subStatus = requestEntity.getSubStatus();
		this.subMessage = requestEntity.getSubMessage();
		this.data = requestEntity.getResult();
		this.costTime = requestEntity.getResponseTime() - requestEntity.getRequestTime();
	}
    
    public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getSubMessage() {
		return subMessage;
	}

	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getCostTime() {
		return costTime;
	}

	public void setCostTime(long costTime) {
		this.costTime = costTime;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
