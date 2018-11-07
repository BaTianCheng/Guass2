package com.cw.guass2.visitor.dao.local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.common.constant.ConfigConstants;
import com.cw.guass2.common.util.FileUtils;
import com.cw.guass2.visitor.entity.InvokeServiceEntity;

/**
 * 调用服务DAO（读取本地）
 * @author wicks
 *
 */
@Repository
public class LocalInvokeServiceDAO {
	
	/**
	 * 获取调用服务列表
	 * @return
	 */
	public List<InvokeServiceEntity> listInvokeServices() {
		
		List<InvokeServiceEntity> invokeServiceEntities = new ArrayList<>();
		String context = "";
		
		try {
			context = FileUtils.read(ConfigConstants.INVOKESERVICE_PATH);
			invokeServiceEntities = JSON.parseArray(context, InvokeServiceEntity.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return invokeServiceEntities;
	}

}
