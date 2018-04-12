package com.safe.info.core.mapper;

import com.safe.info.core.pojo.Company;
import com.safe.info.core.pojo.CompanyDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 单位mapper
 */
public interface CompanyMapper {
    public List<CompanyDetail> queryCompanyPage(@Param("name") String name,
                                                @Param("regionName")String regionName,
                                                @Param("start")int start,
                                                @Param("pageNum")int pageNum);

    public int queryCompanyPageCount(@Param("name")String name,
                                     @Param("regionName")String regionName);

    public CompanyDetail queryCompany(Long id);

    public int insertCompany(Company company);

    public int updateCompany(Company company);


}
