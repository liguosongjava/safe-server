package com.safe.info.core.service;

import com.safe.info.core.pojo.Company;
import com.safe.info.core.vo.CompanyDto;
import com.safe.info.core.vo.CompanyVo;

import java.util.List;

/**
 *
 */
public interface CompanyService {
    public List<CompanyVo> queryCompanyPage(String name,String regionName,
                                            int pageCurrent,int pageSize);

    public int queryCompanyPageCount(String name,String regionName);

    public CompanyVo queryCompany(Long id);

    public boolean addCompany(Company company);

    public boolean updateCompany(Company company);
    //逻辑删除单位
    public boolean DeleteCompanyLogic(List<Long> idList);
}
