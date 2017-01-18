package com.omg.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2016/12/31.
 */
@Controller
@RequestMapping("/demo")
@Scope("prototype")
public class DemoController {
    private int num = 0;
    @RequestMapping("/test")
    public String test(){
        System.out.println("hello");
        System.out.println(num++);
        return "redirect:/categoryList";
    }

    @RequestMapping("/sleep")
    @ResponseBody
    public String test2(HttpServletRequest request) throws Exception{
        String temp = "";
        String flag = request.getParameter("flag");
        if("on".equals(flag)){
            temp += "sa";
            return "first Thread"+temp;
        }
        Thread.currentThread().sleep(10000);
        return "second Thread"+temp;
    }

}
