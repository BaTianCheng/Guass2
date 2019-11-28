package com.demo;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;

@Service
public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "A";
    }


}
