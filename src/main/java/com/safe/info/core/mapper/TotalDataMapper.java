package com.safe.info.core.mapper;

import com.safe.info.core.pojo.TotalData;
import com.safe.info.core.pojo.TotalDataDetail;
import com.safe.info.core.vo.TotalParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 申报总数据mapper
 */
public interface TotalDataMapper {
    public List<TotalDataDetail> queryTotalDataPage(@Param("totalParam")TotalParam totalParam,
                                                    @Param("start")int start,
                                                    @Param("pageNum")int pageSize);

    public int queryTotalDataPageCount(TotalParam totalParam);

    public TotalDataDetail queryTotalData(Long id);

    public int insertTotalData(TotalData totalData);

    public int updateTotalData(TotalData totalData);
}
