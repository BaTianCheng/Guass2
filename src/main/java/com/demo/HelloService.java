package com.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    
    public String say() {
        return "hello springboot !";
    }

}
