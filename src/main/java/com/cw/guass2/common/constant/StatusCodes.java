package com.cw.guass2.common.constant;

/**
 * 状态码常量
 * @author wicks
 *
 */
public enum StatusCodes {

    CODE_SUCCESS("200", "成功"), 
    CODE_SERVER_ERROR("500", "服务错误"), 
    CODE_AUTH_ERROR("300", "权限不足"), 
    CODE_PARAM_ERROR("400", "请求参数错误");
    
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
