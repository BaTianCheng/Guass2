package com.cw.guass2.common.base;

import java.util.Map;

import com.cw.guass2.dispatch.entity.ResponseEntity;

/**
 * 服务处理接口————API接口调用需要实现
 * @author wicks
 *
 */
public interface ServiceHandlerInterface {
	
	public ResponseEntity HandlerRequest(String questId, Map<String, String> params);

}
