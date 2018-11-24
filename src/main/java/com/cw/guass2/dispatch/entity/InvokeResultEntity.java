package com.cw.guass2.dispatch.entity;

import java.io.Serializable;

/**
 * 响应实体类
 * @author wicks
 *
 */
public class InvokeResultEntity implements Serializable{
	
	private static final long serialVersionUID = -1613298792633626900L;
	
	private boolean successFlag = true;

	private String status;
	
	private String message;
	
	private Object data;
	
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
