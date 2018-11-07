package com.cw.guass2.visitor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.guass2.visitor.dao.local.LocalInvokeServiceDAO;
import com.cw.guass2.visitor.entity.InvokeServiceEntity;

/**
 * 调用服务管理器
 * @author wicks
 *
 */
@Service
public class InvokeServiceManger {
	
	@Autowired
	LocalInvokeServiceDAO dao;
	
	public static Logger logger = LoggerFactory.getLogger(InvokeServiceManger.class);
	
	/**
	 * 调用服务列表
	 */
	private static List<InvokeServiceEntity> invokeServiceEntities = new ArrayList<>();
	private static Map<String, InvokeServiceEntity> invokeServiceEntitiesMap = new HashMap<>();
	
	/**
	 * 加载服务列表
	 */
	public void loadInvokeServiceEntities() {
		// 现在采用直接读取加载，后期改为读取缓存等功能
		invokeServiceEntities = dao.listInvokeServices();
		if(null != invokeServiceEntities) {
			for(InvokeServiceEntity invokeServiceEntity : invokeServiceEntities) {
				invokeServiceEntitiesMap.put(invokeServiceEntity.getServiceCode(), invokeServiceEntity);
			}
		}
	}
	
	/**
	 * 返回所有服务列表
	 */
	public List<InvokeServiceEntity> listInvokeServiceEntities() {
		return invokeServiceEntities;
	}
	
	/**
	 * 获取调用服务实体类
	 * @param serviceCode
	 * @return
	 */
	public InvokeServiceEntity getInvokeServiceEntity(String serviceCode) {
		return invokeServiceEntitiesMap.get(serviceCode);
	}
	
}
