package com.iBlog.serviceTest;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTest {
	
	@RequestMapping(value="/Test" , method = RequestMethod.GET)
	@ResponseBody
    public HashMap<Object,Object> Test(){
		HashMap<Object,Object> result = new HashMap<Object,Object>();
		result.put("Status", "200");
		result.put("描述", "GET接口访问测试通过！");
        return result;
    }
}
