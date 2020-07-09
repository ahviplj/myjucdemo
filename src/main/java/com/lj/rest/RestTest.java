package com.lj.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//restful风格理解
//页面展示上url由"?","&"符号都变为"/"
//增删改查方法不再是仅仅使用get/post，还有put和delete
//注意方法参数需要传入@PathVariable注解，同时在@requestMapping，将变量用{}包含起来
//例如：@requestMapping("/rest/{a}/{b}")
@Controller
public class RestTest {
    @RequestMapping("/rest/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果是："+res);
        return "test";
    }

}
