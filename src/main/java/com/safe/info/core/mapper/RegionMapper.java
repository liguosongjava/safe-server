package com.safe.info.core.mapper;

import com.safe.info.core.pojo.Region;
import com.safe.info.core.pojo.RegionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地区mapper
 */
public interface RegionMapper {
    public List<RegionDetail> queryRegionPage(@Param("name")String name,
                                              @Param("start")int start,
                                              @Param("pageNum")int pageNum);

    public int queryRegionPageCount(@Param("name")String name);

    public RegionDetail queryRegion(Long id);

    public int insertRegion(Region region);

    public int updateRegion(Region region);

    public int deleteRegionBatch(List<Long> idList);

    public int deleteRegion(Long id);

}
