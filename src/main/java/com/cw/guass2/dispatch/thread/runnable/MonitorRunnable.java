package com.cw.guass2.dispatch.thread.runnable;

import com.cw.guass2.common.constant.ConfigConstants;
import com.cw.guass2.dispatch.thread.service.ThreadPoolService;
import com.cw.guass2.dispatch.thread.service.ThreadQueue;


/**
 * 线程池监视器
 * @author wicks
 */
public class MonitorRunnable implements Runnable {

	/**
	 * 构造函数
	 */
	public MonitorRunnable() {
		super();
	}

	@Override
	public void run() {
		while(true) {
			// 使用空余线程执行请求
			if(ThreadPoolService.getActiveCount() < ConfigConstants.THREADS_MAX_NUM && ThreadQueue.getSize() > 0) {
				int freeThreadNum = ConfigConstants.THREADS_MAX_NUM - ThreadPoolService.getActiveCount();
				int enqueueNum = freeThreadNum > ThreadQueue.getSize() ? ThreadQueue.getSize() : freeThreadNum;
				while(enqueueNum > 0) {
					//ThreadPoolService.execute(new RequsetRunnable());
					enqueueNum--;
				}
			}

			try {
				Thread.sleep(ConfigConstants.MONITOR_INTERVAL);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
