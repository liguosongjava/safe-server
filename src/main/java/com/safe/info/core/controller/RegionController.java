package com.safe.info.core.controller;

import com.alibaba.fastjson.JSON;
import com.safe.info.core.service.RegionService;
import com.safe.info.core.util.PageUtil;
import com.safe.info.core.vo.ExecuteResult;
import com.safe.info.core.vo.FindRegionVo;
import com.safe.info.core.vo.RegionVo;
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
 * 地区列表
 */
@Controller
@RequestMapping("/region")
public class RegionController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    RegionService regionService;

    @RequestMapping("/list")
    public String list(){
        return "region/list";
    }

    @RequestMapping("/list_data")
    @ResponseBody
    public String listData(@RequestParam Map<String, String> form,
                           HttpServletRequest request){
        int  pageCurrent = getParameterInteger(request,"pageCurrent",1);
        int  pageSize = getParameterInteger(request,"pageSize",60);
        String name = request.getParameter("region.name");
        List<RegionVo> list = regionService.queryRegionPage(name,pageCurrent,pageSize);
        PageUtil<RegionVo> pages = PageUtil.pageHelp(pageCurrent,pageSize);
        int TotalCount = regionService.queryRegionPageCount(name);
        pages.setCount(TotalCount);
        pages.setList(list);
        return JSON.toJSONString(pages);
    }

    @RequestMapping("/find_region_data")
    @ResponseBody
    public String findRegionData(@RequestParam Map<String, String> form,
                                 HttpServletRequest request){
        int  pageCurrent = getParameterInteger(request,"pageCurrent",1);
        int  pageSize = getParameterInteger(request,"pageSize",60);
        String name = request.getParameter("region.name");
        List<RegionVo> list = regionService.queryRegionPage(name,pageCurrent,pageSize);
        PageUtil<FindRegionVo> pages = PageUtil.pageHelp(pageCurrent,pageSize);
        List<FindRegionVo> findList = new ArrayList<>();
        for (RegionVo regionVo: list){
            FindRegionVo findRegionVo = new FindRegionVo(regionVo.getId(),
                    regionVo.getName(),regionVo.getRemark());
            findList.add(findRegionVo);
        }
        int TotalCount = regionService.queryRegionPageCount(name);
        pages.setCount(TotalCount);
        pages.setList(findList);
        return JSON.toJSONString(pages);
    }

    @RequestMapping("/edit")
    public String edit(ModelMap model, HttpServletRequest request){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){ //新增
            return "region/add";
        }else{
            //查询地区信息
            RegionVo regionVo = regionService.queryRegion(Long.valueOf(id));
            model.put("region",regionVo);
            return "region/edit";
        }
    }

    @RequestMapping("/save_edit")
    @ResponseBody
    public String saveEdit(@RequestParam Map<String, String> form,HttpServletRequest request){
        String name = request.getParameter("region.name");
        String remark = request.getParameter("region.remark");
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(remark)){
            return ExecuteResult.jsonReturn(300,"地区名或备注为空");
        }
        boolean flag = false;
        if(StringUtils.isEmpty(request.getParameter("id"))){ //新增
            flag = regionService.addRegion(name,remark);
        }else{//更新
            flag = regionService.updateRegion(Long.valueOf(id),name,remark);
        }
        if(flag){
            return ExecuteResult.jsonReturn(200);
        }else {
            return ExecuteResult.jsonReturn(300,"编辑失败请重试");
        }
    }

    @RequestMapping("/detail")
    public String detail(){
        return "region/detail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request){
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
        regionService.deleteRegionLogic(idList);
        return ExecuteResult.jsonReturn(200);
    }
}
