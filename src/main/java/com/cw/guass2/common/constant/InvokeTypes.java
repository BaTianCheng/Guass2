package com.cw.guass2.common.constant;

/**
 * 调用方式
 * @author wicks
 *
 */
public enum InvokeTypes {

    API("API");
    
    private String code;
    
    private InvokeTypes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
