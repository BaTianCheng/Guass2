package com.cw.guass2.common.constant;

/**
 * 状态码常量
 * @author wicks
 *
 */
public enum StatusCodes {

	CODE_PRENDING("100", "准备"), 
    CODE_SUCCESS("200", "成功"), 
    CODE_AUTH_ERROR("300", "权限错误"), 
    CODE_REQUEST_ERROR("400", "请求错误"),
	CODE_PARAM_ERROR("410", "请求参数错误"),
	CODE_TIMEOUT_ERROR("420", "请求超时"),
    CODE_SERVER_ERROR("500", "服务错误"), 
    CODE_RESULT_EMPTY("600", "无结果");
    
    private String code;
    private String desc;
    
    private StatusCodes(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
