package com.cw.guass2.common.base;

import java.util.Map;

import com.cw.guass2.dispatch.entity.InvokeResultEntity;

/**
 * 服务处理接口————API接口调用需要实现
 * @author wicks
 *
 */
public interface ServiceHandlerInterface {
	
	public InvokeResultEntity HandlerRequest(String questId, Map<String, String> params);

}
