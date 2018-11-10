package com.cw.guass2.dispatch.entity;

import java.io.Serializable;

/**
 * 响应实体类
 * @author wicks
 *
 */
public class ResponseEntity implements Serializable{
	
	private static final long serialVersionUID = -1613298792633626900L;
	
	private boolean successFlag = true;

	private String status;
	
	private String message;
	
	private String data;
	
	public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
