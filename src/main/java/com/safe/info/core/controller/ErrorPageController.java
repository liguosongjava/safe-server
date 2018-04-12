package com.safe.info.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常页面
 */
@Controller
public class ErrorPageController {

    @RequestMapping("404")
    public String to404Page(){
        return "/error/404";
    }

    @RequestMapping("500")
    public String to500Page(){
        return "/error/500";
    }
}
