package com.safe.info.core.mapper;

import com.safe.info.core.pojo.HouseholdRegister;

/**
 * 户籍数据
 */
public interface HouseholdRegisterMapper {
    public HouseholdRegister selectHouseholdRegisterByNo(String idNo);

    public int insert(HouseholdRegister householdRegister);
}
