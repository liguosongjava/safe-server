package com.safe.info.core.service.impl;

import com.safe.info.core.mapper.RegionMapper;
import com.safe.info.core.pojo.Region;
import com.safe.info.core.pojo.RegionDetail;
import com.safe.info.core.service.RegionService;
import com.safe.info.core.util.SessionLocal;
import com.safe.info.core.util.DateUtil;
import com.safe.info.core.vo.RegionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    private static final Logger logger = LoggerFactory.getLogger(RegionServiceImpl.class);
    @Autowired
    RegionMapper regionMapper;


    @Override
    public List<RegionVo> queryRegionPage(String name,int pageCurrent,int pageSize) {
        int start = (pageCurrent-1)*pageSize;
        List<RegionDetail> regions = regionMapper.queryRegionPage(name,start,pageSize);
        List<RegionVo> regionVos = new ArrayList<>();
        for (RegionDetail region : regions){
            String createTime = null;
            try {
                createTime = DateUtil.parseTime(region.getCreateTime(),DateUtil.SP1);
            } catch (ParseException e) {
                logger.info("parseTime error,id:{}",region.getId());
            }
            RegionVo regionVo = new RegionVo(createTime,region.getId(),region.getName(),
                    region.getRemark(),region.getCreateCustomerName());
            regionVos.add(regionVo);
        }
        return regionVos;
    }

    @Override
    public int queryRegionPageCount(String name) {
        return 0;
    }

    @Override
    public RegionVo queryRegion(Long id) {
        RegionDetail regionDetail = regionMapper.queryRegion(id);
        String createTime = null;
        try {
            createTime = DateUtil.parseTime(regionDetail.getCreateTime(),DateUtil.SP1);
        } catch (ParseException e) {
            logger.info("parseTime error,id:{}",regionDetail.getId());
        }
        RegionVo regionVo = new RegionVo(createTime,regionDetail.getId(),regionDetail.getName(),
                regionDetail.getRemark(),regionDetail.getCreateCustomerName());
        return regionVo;
    }

    @Override
    public boolean addRegion(String name, String remark) {
        Region region = new Region();
        region.setName(name);
        region.setRemark(remark);
        region.setCreateCustomer(SessionLocal.getUser().getCustomerId());
        int insertNum = regionMapper.insertRegion(region);
        if(insertNum<1){
            logger.error("insertRegion fail,region:{}",region);
            return false;
        }else {
            return true;
        }

    }

    @Override
    public boolean updateRegion(Long id, String name, String remark) {
        Region region = new Region();
        region.setId(id);
        region.setName(name);
        region.setRemark(remark);
        region.setState(1);
        int updateNum = regionMapper.updateRegion(region);
        if(updateNum<1){
            logger.error("updateRegion fail,region:{}",region);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean deleteRegionLogic(List<Long> idList) {
        for(Long id : idList){
            Region region = new Region();
            region.setId(id);
            region.setState(0);
            regionMapper.updateRegion(region);
        }
        return true;
    }
}
