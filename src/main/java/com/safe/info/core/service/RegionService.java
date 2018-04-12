package com.safe.info.core.service;


import com.safe.info.core.vo.RegionVo;

import java.util.List;

/**
 * 地区service
 */
public interface RegionService {
    public List<RegionVo> queryRegionPage(String name,int pageCurrent,int pageSize);

    public int queryRegionPageCount(String name);

    public RegionVo queryRegion(Long id);

    public boolean addRegion(String name,String remark);

    public boolean updateRegion(Long id,String name,String remark);
    //逻辑删除地区
    public boolean deleteRegionLogic(List<Long> idList);
}
