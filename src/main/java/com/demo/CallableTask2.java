package com.demo;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;

@Service
public class CallableTask2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "B";
    }


}
