package com.safe.info.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资料导入
 */
@Controller
@RequestMapping("data_import")
public class DataImportController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(DataImportController.class);

    //户籍数据导入页
    @RequestMapping("house_register")
    public String toHrePage(){
        return "/import/houseReg";
    }
    //房产数据导入页
    @RequestMapping("house_pro")
    public String toHproPage(){
        return "/import/housePro";
    }
}
