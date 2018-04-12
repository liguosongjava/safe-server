package com.safe.info.core.service.impl;

import com.safe.info.core.mapper.CompanyMapper;
import com.safe.info.core.pojo.Company;
import com.safe.info.core.pojo.CompanyDetail;
import com.safe.info.core.service.CompanyService;
import com.safe.info.core.util.SessionLocal;
import com.safe.info.core.vo.CompanyVo;
import com.safe.info.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<CompanyVo> queryCompanyPage(String name,String regionName,int pageCurrent,int pageSize) {
        int start = (pageCurrent-1)*pageSize;
        List<CompanyDetail> companyDetailList = companyMapper.queryCompanyPage(name,regionName,start,pageSize);
        List<CompanyVo> companyVoList = new ArrayList<>();
        for(CompanyDetail companyDetail : companyDetailList){
            CompanyVo companyVo = new CompanyVo();
            companyVo.setId(companyDetail.getId());
            companyVo.setName(companyDetail.getName());
            companyVo.setAddress(companyDetail.getAddress());
            companyVo.setPhone(companyDetail.getPhone());
            companyVo.setRegionId(companyDetail.getRegionId());
            companyVo.setRegionName(companyDetail.getRegionName());
            companyVo.setDeclareNum(companyDetail.getDeclareNum());
//            companyVo.setDeclareGrade(companyDetail.getDeclareGrade());
//            companyVo.setDeclareType(companyDetail.getDeclareType());
            companyVo.setCompanyLevel(companyDetail.getCompanyLevel());
            companyVo.setHouseCheck(companyDetail.getHouseCheck());
            companyVo.setHregisterCheck(companyDetail.getHregisterCheck());
            companyVo.setRemark(companyDetail.getRemark());
            companyVo.setCreateCustomerName(companyDetail.getCreateCustomerName());
            companyVo.setCreateCustomer(companyDetail.getCreateCustomer());
            String createTime = null;
            try {
                createTime = DateUtil.parseTime(companyDetail.getCreateTime(),DateUtil.SP1);
            } catch (ParseException e) {
                logger.info("parseTime error,id:{}",companyDetail.getId());
            }
            companyVo.setCreateTime(createTime);
            companyVoList.add(companyVo);
        }
        return companyVoList;
    }

    @Override
    public int queryCompanyPageCount(String name, String regionName) {
        return companyMapper.queryCompanyPageCount(name,regionName);
    }

    @Override
    public CompanyVo queryCompany(Long id) {
        CompanyDetail companyDetail = companyMapper.queryCompany(id);
        CompanyVo companyVo = new CompanyVo();
        {
            companyVo.setId(companyDetail.getId());
            companyVo.setName(companyDetail.getName());
            companyVo.setAddress(companyDetail.getAddress());
            companyVo.setPhone(companyDetail.getPhone());
            companyVo.setRegionId(companyDetail.getRegionId());
            companyVo.setRegionName(companyDetail.getRegionName());
            companyVo.setDeclareNum(companyDetail.getDeclareNum());
            companyVo.setCompanyLevel(companyDetail.getCompanyLevel());
            companyVo.setHouseCheck(companyDetail.getHouseCheck());
            companyVo.setHregisterCheck(companyDetail.getHregisterCheck());
            companyVo.setRemark(companyDetail.getRemark());
            companyVo.setCreateCustomerName(companyDetail.getCreateCustomerName());
            companyVo.setCreateCustomer(companyDetail.getCreateCustomer());
            if(companyDetail.getDeclareGrade() != null){
                List<String> idListStr = Arrays.asList(companyDetail.getDeclareGrade().split(","));
                List<Long> idList = new ArrayList<>();
                for(String idStr : idListStr){
                    idList.add(Long.valueOf(idStr));
                }
                companyVo.setDeclareGrade(idList);
            }
            if(companyDetail.getDeclareType() != null){
                List<String> idListStr = Arrays.asList(companyDetail.getDeclareType().split(","));
                List<Integer> idList = new ArrayList<>();
                for(String idStr : idListStr){
                    idList.add(Integer.valueOf(idStr));
                }
                companyVo.setDeclareType(idList);
            }
        }
        return companyVo;
    }

    @Override
    public boolean addCompany(Company company) {
        company.setCreateCustomer(SessionLocal.getUser().getCustomerId());
        int insertNum = companyMapper.insertCompany(company);
        return insertNum<1?false:true;
    }

    @Override
    public boolean updateCompany(Company company) {
        int insertNum = companyMapper.updateCompany(company);
        return insertNum<1?false:true;
    }

    @Override
    public boolean DeleteCompanyLogic(List<Long> idList) {
        for(Long id : idList){
            Company company = new Company();
            company.setId(id);
            company.setState(0);
            companyMapper.updateCompany(company);
        }
        return true;
    }
}
