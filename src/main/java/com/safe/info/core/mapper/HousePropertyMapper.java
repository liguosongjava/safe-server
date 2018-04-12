package com.safe.info.core.mapper;

import com.safe.info.core.pojo.HouseProperty;

/**
 * 房产数据
 */
public interface HousePropertyMapper {

    public HouseProperty selectHousePropertyByNo(String no);

    public int insert(HouseProperty houseProperty);
}
