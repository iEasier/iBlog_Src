package com.iBlog.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTest {
	
	@RequestMapping(value="/helloworld" , method = RequestMethod.POST)
	@ResponseBody
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
