package com.youngstone.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloResource {

    @Value("${spring.message}")
    private String message;


    @Value("${welcome.message}")
    private String welcomeMesage;


    @Autowired
    private BasicConfiguration configuration;


    @GetMapping("/properties/hello")
    public String hello(){
        return message;
    }


    @GetMapping("/properties/welcome")
    public String welcome(){
        return welcomeMesage;
    }

    @RequestMapping("/dynamic-config")
    public Map dynamicConfig(){
        Map map = new HashMap();
        map.put("message",configuration.getMessage());
        map.put("number",configuration.getNumber());
        map.put("key",configuration.isValue());
        return map;
    }
}
