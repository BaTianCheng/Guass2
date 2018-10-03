package com.cw.guass2.dispatch.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作处理类————处理所有线程工作
 * @author wicks
 *
 */
public class WorkHandler implements Runnable {

	public static Logger logger = LoggerFactory.getLogger(WorkHandler.class);

	/**
	 * 构造函数
	 */
	public WorkHandler() {
		super();
	}
	
	/**
	 * 执行线程工作
	 */
	@Override
	public void run() {
		/*
		 * 工作流程：
		 * 1）接受响应
		 * 2）调用处理方式
		 * 3）封装结果
		 * 4）输出结果
		 */
		
	}
}


