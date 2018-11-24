package com.cw.guass2.common.base;

import com.cw.guass2.dispatch.entity.InvokeResultEntity;
import com.cw.guass2.dispatch.entity.ParamEntity;

/**
 * 服务处理接口————API接口调用需要实现
 * @author wicks
 *
 */
public abstract class BaseServiceHandler {
	
	public abstract InvokeResultEntity HandlerRequest(String questId, ParamEntity params);
	
	/**
	 * 构建成功结果
	 * @return
	 */
	public InvokeResultEntity buidSucessResult(Object data) {
		InvokeResultEntity invokeResultEntity = new InvokeResultEntity();
		invokeResultEntity.setData(data);
		return invokeResultEntity;
	}
	
	/**
	 * 构建错误结果
	 * @return
	 */
	public InvokeResultEntity buidErrorResult(String statusCode, String message, Object data) {
		InvokeResultEntity invokeResultEntity = new InvokeResultEntity();
		invokeResultEntity.setSuccessFlag(false);
		invokeResultEntity.setStatus(statusCode);
		invokeResultEntity.setMessage(message);
		invokeResultEntity.setData(data);
		return invokeResultEntity;
	}

}
