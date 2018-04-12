package com.safe.info.core.service.impl;


import com.safe.info.core.mapper.TotalDataMapper;
import com.safe.info.core.pojo.TotalData;
import com.safe.info.core.pojo.TotalDataDetail;
import com.safe.info.core.service.TotalDataService;
import com.safe.info.core.vo.TotalParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalDataServiceImpl implements TotalDataService {
    private static final Logger logger = LoggerFactory.getLogger(TotalDataServiceImpl.class);

    @Autowired
    TotalDataMapper totalDataMapper;

    @Override
    public List<TotalDataDetail> queryTotalDataPage(TotalParam totalParam,int pageCurrent,int pageSize) {
        int start = (pageCurrent-1)*pageSize;
        List<TotalDataDetail> pageList = totalDataMapper.queryTotalDataPage(totalParam,start,pageSize);
        return pageList;
    }

    @Override
    public int queryTotalDataPageCount(TotalParam totalParam) {
        return totalDataMapper.queryTotalDataPageCount(totalParam);
    }

    @Override
    public TotalDataDetail queryTotalData(Long id) {
        TotalDataDetail totalDataDetail = totalDataMapper.queryTotalData(id);
        return totalDataDetail;
    }

    @Override
    public boolean addTotalData(TotalData totalData) {
        int insertNum = totalDataMapper.insertTotalData(totalData);
        return insertNum<1?false:true;
    }

    @Override
    public boolean updateTotalData(TotalData totalData) {
        int updateNum = totalDataMapper.updateTotalData(totalData);
        return updateNum<1?false:true;
    }

    @Override
    public boolean deleteTotalDataLogic(List<Long> idList) {
        return false;
    }
}
