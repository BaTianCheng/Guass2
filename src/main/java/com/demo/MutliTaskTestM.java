package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MutliTaskTestM {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService eService = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask();
        CallableTask2 task2 = new CallableTask2();
        
        /*
        Future<String> future1 = eService.submit(task1);
        Future<String> future2 = eService.submit(task2);
        List<Future<String>> list = new ArrayList<>();
        list.add(future1);
        list.add(future2);
        
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).get());
        }
        */
        
        /*
        Future<String> future1 = eService.submit(task1);
        Future<String> future2 = eService.submit(task2);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        eService.execute(()->{
            try {
                queue.put(future1.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        eService.execute(()->{
            try {
                queue.put(future2.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        for(int i=0;i<2;i++) {
            System.out.println(queue.take());
        }
        */
        
    }
}
