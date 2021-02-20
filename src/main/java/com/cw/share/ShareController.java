package com.cw.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ShareController {
    
    @Autowired
    ShareService shareService;
    
    @RequestMapping(value = "/getAAA")
    public String GetAAA() {
        return "";
    }

}
