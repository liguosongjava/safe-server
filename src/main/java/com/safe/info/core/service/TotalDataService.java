package com.safe.info.core.service;

import com.safe.info.core.pojo.TotalData;
import com.safe.info.core.pojo.TotalDataDetail;
import com.safe.info.core.vo.TotalParam;

import java.util.List;

/**
 * 申报数据
 */
public interface TotalDataService {
    public List<TotalDataDetail> queryTotalDataPage(TotalParam totalParam,int pageCurrent,int pageSize);

    public int queryTotalDataPageCount(TotalParam totalParam);

    public TotalDataDetail queryTotalData(Long id);

    public boolean addTotalData(TotalData totalData);

    public boolean updateTotalData(TotalData totalData);
    //逻辑删除地区
    public boolean deleteTotalDataLogic(List<Long> idList);
}
