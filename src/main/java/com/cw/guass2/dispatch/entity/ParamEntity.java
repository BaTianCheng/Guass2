package com.cw.guass2.dispatch.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * 参数实体类
 * @author wicks
 *
 */
public class ParamEntity implements Serializable{
    
    private static final long serialVersionUID = 2117870862187278067L;
    
    private Map<String, String[]> params;
    
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ParamEntity(RequestEntity requestEntity) {
        this.params = requestEntity.getParams();
        this.body = requestEntity.getPostBody();
    }

    public void setParams(Map<String, String[]> params) {
        this.params = params;
    }
    
    public String getParam(String key) {
        if(params.containsKey(key) && params.get(key) != null && params.get(key).length > 0) {
            return params.get(key)[0];
        } else {
            return null;
        }
    }
    
    public String[] getParams(String key) {
        return params.get(key);
    }
    
    public Map<String, String[]> getParamMap() {
        return params;
    }

}
