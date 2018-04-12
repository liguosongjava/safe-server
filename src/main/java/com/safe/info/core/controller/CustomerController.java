package com.safe.info.core.controller;

import com.alibaba.fastjson.JSON;
import com.safe.info.core.service.CustomerService;
import com.safe.info.core.util.PageUtil;
import com.safe.info.core.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户控制类
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService CustomerService;

    @RequestMapping("/list")
    public String list(){
        return "customer/list";
    }

    @RequestMapping("/list_data")
    @ResponseBody
    public String listData(HttpServletRequest request,ModelMap model,
                           @RequestParam Map<String, String> form){
        int  pageCurrent = getParameterInteger(request,"pageCurrent",1);
        int  pageSize = getParameterInteger(request,"pageSize",60);
        String name = request.getParameter("customer.name");
        String regionName = request.getParameter("customer.regionName");
        String companyName = request.getParameter("customer.companyName");
        List<CustomerVo> list = CustomerService.queryCustomerPage(name,companyName,regionName,
                pageCurrent,pageSize);
        PageUtil<CustomerVo> pages = PageUtil.pageHelp(pageCurrent,pageSize);
        int totalCount = CustomerService.queryCustomerCount(name,companyName,regionName);
        pages.setCount(totalCount);
        pages.setList(list);
        return JSON.toJSONString(pages);
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request,ModelMap model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){ //新增
            return "customer/add";
        }else{
            //查询用户信息
            CustomerVo customerVo = CustomerService.queryCustomer(Long.valueOf(id));
            model.put("customer",customerVo);
            return "customer/edit";
        }
    }

    @RequestMapping("/save_edit")
    @ResponseBody
    public String saveEdit(HttpServletRequest request,ModelMap model){
        String id = request.getParameter("id");
        //参数校验
        if(false){
            return ExecuteResult.jsonReturn(300,"请填写必填的数据");
        }
        CustomerDto customerDto = new CustomerDto();
        boolean flag = false;
        if(StringUtils.isEmpty(request.getParameter("id"))){ //新增
            flag = CustomerService.addCustomer(customerDto);
        }else{//更新
            flag = CustomerService.updateCustomer(customerDto);
        }
        if(flag){
            return ExecuteResult.jsonReturn(200);
        }else {
            return ExecuteResult.jsonReturn(300,"编辑失败请重试");
        }
    }

    @RequestMapping("/detail")
    public String detail(HttpServletRequest request,ModelMap model){
        String id = request.getParameter("id");
        //查询用户信息
        CustomerVo customerVo = CustomerService.queryCustomer(Long.valueOf(id));
        model.put("customer",customerVo);
        return "customer/detail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request, ModelMap model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return ExecuteResult.jsonReturn(300,"请选择要删除的数据");
        }
        List<String> idListStr = Arrays.asList(id.split(","));
        if(idListStr.isEmpty()){
            return ExecuteResult.jsonReturn(300,"请选择要删除的数据");
        }
        List<Long> idList = new ArrayList<>();
        for(String idStr : idListStr){
            idList.add(Long.valueOf(idStr));
        }
        CustomerService.deleteCustomerLogic(idList);
        return ExecuteResult.jsonReturn(200);
    }
}
