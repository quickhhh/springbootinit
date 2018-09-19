package com.example.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m, @RequestParam(value = "isbad",required = false) String isbad) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if("bad".equals(isbad)){
            throw new Exception("bad");
        }
        System.out.println("中文乱码");
        m.addAttribute("name","jone12321");
        return "hello";
    }
}
