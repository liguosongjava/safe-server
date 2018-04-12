package com.safe.info.core.controller;

import com.alibaba.fastjson.JSON;
import com.safe.info.core.pojo.Company;
import com.safe.info.core.service.CompanyService;
import com.safe.info.core.util.PageUtil;
import com.safe.info.core.vo.CompanyDto;
import com.safe.info.core.vo.CompanyVo;
import com.safe.info.core.vo.DwzJsonResponse;
import com.safe.info.core.vo.ExecuteResult;
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
 * 单位列表
 */
@Controller
@RequestMapping("/company")
public class CompanyComtroller extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CompanyComtroller.class);

    @Autowired
    CompanyService companyService;

    @RequestMapping("/list")
    public String list(){
        return "company/list";
    }

    @RequestMapping("/list_data")
    @ResponseBody
    public String listData(@RequestParam Map<String, String> form,HttpServletRequest request){
        int  pageCurrent = getParameterInteger(request,"pageCurrent",1);
        int  pageSize = getParameterInteger(request,"pageSize",60);
        String name = request.getParameter("company.name");
        String regionName = request.getParameter("company.regionName");
        List<CompanyVo> list = companyService.queryCompanyPage(name,regionName,pageCurrent,pageSize);
        PageUtil<CompanyVo> pages = PageUtil.pageHelp(pageCurrent,pageSize);
        int totalCount = companyService.queryCompanyPageCount(name,regionName);
        pages.setCount(totalCount);
        pages.setList(list);
        return JSON.toJSONString(pages);
    }

    @RequestMapping("/edit")
    public String edit(ModelMap model, HttpServletRequest request){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){ //新增
            return "company/add";
        }else{
            //查询单位信息
            CompanyVo companyVo = companyService.queryCompany(Long.valueOf(id));
            model.put("company",companyVo);
            return "company/edit";
        }
    }

    @RequestMapping("/save_edit")
    @ResponseBody
    public String saveEdit(@RequestParam Map<String, String> form,HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("company.name");
        String address = request.getParameter("company.address");
        String phone = request.getParameter("company.phone");
        String regionId = request.getParameter("company.regionId");
        String regionName = request.getParameter("company.regionName");
        String declareNum = request.getParameter("company.declareNum");
        String declareType = request.getParameter("company.declareType");
        String declareGrade = request.getParameter("company.declareGrade");
        String companyLevel = request.getParameter("company.companyLevel");
        String houseCheck = request.getParameter("company.houseCheck");
        String hregisterCheck = request.getParameter("company.hregisterCheck");
        String remark = request.getParameter("company.remark");

        //参数校验
        if(form.size()<12){
            return ExecuteResult.jsonReturn(300,"请补全信息");
        }
        Company companyDto = new Company();
        {
            companyDto.setName(name);
            companyDto.setAddress(address);
            companyDto.setPhone(phone);
            companyDto.setRegionId(Long.valueOf(regionId));
            companyDto.setDeclareNum(Long.valueOf(declareNum));
            companyDto.setDeclareType(declareType);
            companyDto.setDeclareGrade(declareGrade);
            companyDto.setCompanyLevel(companyLevel);
            companyDto.setHouseCheck(houseCheck);
            companyDto.setHregisterCheck(hregisterCheck);
            companyDto.setRemark(remark);
        }
        boolean flag = false;
        if(StringUtils.isEmpty(request.getParameter("id"))){ //新增
            flag = companyService.addCompany(companyDto);
        }else{//更新
            companyDto.setId(Long.valueOf(id));
            flag = companyService.updateCompany(companyDto);
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
        //查询单位信息
        CompanyVo companyVo = companyService.queryCompany(Long.valueOf(id));
        model.put("company",companyVo);
        return "company/detail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request,ModelMap model){
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
        companyService.DeleteCompanyLogic(idList);
        return ExecuteResult.jsonReturn(200);
    }
}
