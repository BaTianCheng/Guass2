package com.cw.guass2.dispatch.thread.service;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 线程队列服务
 * @author wicsks
 *
 */
public class ThreadQueue {
	
	/**
	 * 线程安全有序队列
	 */
	private static ConcurrentLinkedQueue<Object> queue;
	private static ConcurrentLinkedQueue<Object> priorityQueue;

	static {
		queue = new ConcurrentLinkedQueue<Object>();
		priorityQueue = new ConcurrentLinkedQueue<Object>();
	}

	/**
	 * 入普通队列
	 * @param obj
	 */
	public static void add(Object obj) {
		queue.add(obj);
	}

	/**
	 * 入优先队列
	 * @param obj
	 */
	public static void addPriority(Object obj) {
		priorityQueue.add(obj);
	}

	/**
	 * 出队
	 * @return
	 */
	public static Object poll() {
		// 优先队列享有优先出队权利
		if(priorityQueue.size() > 0) {
			return priorityQueue.poll();
		} else if(queue.size() > 0) {
			return queue.poll();
		} else {
			return null;
		}
	}

	/**
	 * 获取队列长度
	 * @return
	 */
	public static int getSize() {
		return priorityQueue.size() + queue.size();
	}


}
