package com.demo;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public String execute() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "A";
    }
    
    
}
