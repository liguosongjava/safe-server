package com.safe.info.core.controller;

import com.alibaba.fastjson.JSON;
import com.safe.info.core.mapper.HousePropertyMapper;
import com.safe.info.core.mapper.HouseholdRegisterMapper;
import com.safe.info.core.pojo.HouseProperty;
import com.safe.info.core.pojo.HouseholdRegister;
import com.safe.info.core.pojo.TotalData;
import com.safe.info.core.pojo.TotalDataDetail;
import com.safe.info.core.service.TotalDataService;
import com.safe.info.core.util.IDNumberUtil;
import com.safe.info.core.util.PageUtil;
import com.safe.info.core.vo.DwzJsonResponse;
import com.safe.info.core.vo.ExecuteResult;
import com.safe.info.core.vo.TotalParam;
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
import java.util.*;

/**
 * 总数据表
 */
@Controller
@RequestMapping("/totalData")
public class TotalDataController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    TotalDataService totalDataService;
    @Autowired
    HousePropertyMapper housePropertyMapper;

    @Autowired
    HouseholdRegisterMapper householdRegisterMapper;

    @RequestMapping("/list")
    public String list(){
        return "totalData/list";
    }

    @RequestMapping("/list_data")
    @ResponseBody
    public String listData(HttpServletRequest request, ModelMap model,
                           @RequestParam Map<String, String> form){
        int  pageCurrent = getParameterInteger(request,"pageCurrent",1);
        int  pageSize = getParameterInteger(request,"pageSize",60);
        String regionName = request.getParameter("totalData.regionName");
        String companyName = request.getParameter("totalData.companyName");
        String studentName = request.getParameter("totalData.studentName");
        String studentIdNo = request.getParameter("totalData.studentIdNo");
        Integer declareType = getParameterInteger(request,"totalData.declareType",null);
        Integer declareGrade = getParameterInteger(request,"totalData.declareGrade",null);
        Integer auditStatus = getParameterInteger(request,"totalData.auditStatus",null);
        TotalParam totalParam = new TotalParam(regionName,companyName,studentName,studentIdNo,
                declareType,declareGrade,auditStatus);
        List<TotalDataDetail> list = totalDataService.queryTotalDataPage(totalParam,pageCurrent,pageSize);
        PageUtil<TotalDataDetail> pages = PageUtil.pageHelp(pageCurrent,pageSize);
        int totalCount = totalDataService.queryTotalDataPageCount(totalParam);
        pages.setCount(totalCount);
        pages.setList(list);
        return JSON.toJSONString(pages);
    }


    @RequestMapping("/edit")
    public String edit(HttpServletRequest request,ModelMap model){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){ //新增
            return "totalData/add";
        }else{
            //查询地区信息
            TotalDataDetail totalDataDetail = totalDataService.queryTotalData(Long.valueOf(id));
            model.put("totalData",totalDataDetail);
            return "totalData/edit";
        }
    }

    @RequestMapping("/save_edit")
    @ResponseBody
    public String saveEdit(@RequestParam Map<String, String> form,HttpServletRequest request){
        String id = request.getParameter("id");
        //参数校验
        if(form.size()<20){
            return ExecuteResult.jsonReturn(300,"请补全信息");
        }
        boolean flag = false;
        TotalData totalData = new TotalData();
        if(StringUtils.isEmpty(request.getParameter("id"))){ //新增
            flag = totalDataService.addTotalData(totalData);
        }else{//更新
            totalData.setId(Long.valueOf(id));
            flag = totalDataService.updateTotalData(totalData);
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
        //查询地区信息
        TotalDataDetail totalDataDetail = totalDataService.queryTotalData(Long.valueOf(id));
        model.put("totalData",totalDataDetail);
        return "totalData/detail";
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
        totalDataService.deleteTotalDataLogic(idList);
        return ExecuteResult.jsonReturn(200);
    }
    @RequestMapping("/export")
    public void export(){
    }

    @RequestMapping("/query_house_property")
    @ResponseBody
    public String queryHouseProperty(HttpServletRequest request){
        String certificatesNo = request.getParameter("certificates_no");
        Map<String,Object> resMap = new HashMap<>();
        if(StringUtils.isEmpty(certificatesNo)){
            resMap.put("code",300);
            resMap.put("msg","请输入正确的房产证号");
            return  JSON.toJSONString(resMap);
        }
        HouseProperty houseProperty = housePropertyMapper.selectHousePropertyByNo(certificatesNo);
        if(houseProperty==null){
            resMap.put("code",300);
            resMap.put("msg","未查到该房产信息");
            return  JSON.toJSONString(resMap);
        }
        resMap.put("code",200);
        resMap.put("msg","查询成功");
        resMap.put("hpdata",houseProperty);
        return  JSON.toJSONString(resMap);
    }

    @RequestMapping("/query_household_register")
    @ResponseBody
    public String queryHouseholdRegister(HttpServletRequest request){
        String studentIdNo = request.getParameter("student_id_no");
        Map<String,Object> resMap = new HashMap<>();
        if(StringUtils.isEmpty(studentIdNo)){
            resMap.put("code",300);
            resMap.put("msg","请输入身份证号");
            return  JSON.toJSONString(resMap);
        }
        if(!IDNumberUtil.isIDNumber(studentIdNo)){
            resMap.put("code",300);
            resMap.put("msg","身份证号格式不正确");
            return  JSON.toJSONString(resMap);
        }
        HouseholdRegister householdRegister = householdRegisterMapper.selectHouseholdRegisterByNo(studentIdNo);
        if(householdRegister==null){
            resMap.put("code",300);
            resMap.put("msg","未查到该生户籍信息");
            return  JSON.toJSONString(resMap);
        }
        householdRegister.setBirthday(IDNumberUtil.CutId(studentIdNo));
        resMap.put("code",200);
        resMap.put("msg","查询成功");
        resMap.put("hrdata",householdRegister);
        return  JSON.toJSONString(resMap);
    }

}
