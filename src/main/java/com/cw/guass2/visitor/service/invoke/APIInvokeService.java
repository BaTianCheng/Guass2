package com.cw.guass2.visitor.service.invoke;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.common.constant.ConfigConstants;
import com.cw.guass2.common.constant.StatusCodes;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.entity.ResponseEntity;


/**
 * API调用方式
 * @author wicks
 *
 */
@Service
public class APIInvokeService {
	
	public static Logger logger = LoggerFactory.getLogger(APIInvokeService.class);
	
	/**
	 * 调用
	 * @param requestEntity
	 * @return
	 */
	public void invoke(RequestEntity requestEntity){
		
		ResponseEntity result = new ResponseEntity();
		
		try {
			if(null != requestEntity.getInvokeServiceEntity() && null != requestEntity.getInvokeServiceEntity().getMapURL()) {
				Class<?> clazz = Class.forName(requestEntity.getInvokeServiceEntity().getMapURL());
				Method method = clazz.getMethod(ConfigConstants.API_HANDLER_NAME, String.class, Map.class);
				result = (ResponseEntity) method.invoke(clazz.newInstance(), requestEntity.getRequestId(), requestEntity.getParams());
				requestEntity.setResponseTime(System.currentTimeMillis());
				
				// 回收资源
				clazz = null;
				method = null;
			}
			
			// 执行处理程序成功
			if(result.isSuccessFlag()) {
			    requestEntity.setStatus(StatusCodes.CODE_SUCCESS.getCode());
	            requestEntity.setResult(result.getData());
			} else {
				requestEntity.setStatus(StatusCodes.CODE_SERVER_ERROR.getCode());
				requestEntity.setSubStatus(result.getStatus());
				requestEntity.setResult(result.getData());
				requestEntity.setMessage(result.getMessage());
			}
			

		} catch(Throwable thrown) {
			requestEntity.setResponseTime(System.currentTimeMillis());
			requestEntity.setStatus(StatusCodes.CODE_SERVER_ERROR.getCode());
			logger.error("API请求发送异常：" + requestEntity.getRequestId(), thrown);
		}
		
		logger.info("【请求】"+JSON.toJSONString(requestEntity));
		logger.info("【响应】"+JSON.toJSONString(result));

	}

}
