package com.safe.info.core.service;

import com.safe.info.core.vo.CustomerDto;
import com.safe.info.core.vo.CustomerVo;
import com.safe.info.core.vo.LoginInfo;

import java.util.List;

/**
 * 用户登录
 */
public interface CustomerService {
    /**
     * 登录
     * @param loginNo
     * @param password
     */
    public LoginInfo login(String loginNo, String password,String ip);


    public boolean changepwd(Long customerId,String newPwd);

    public List<CustomerVo> queryCustomerPage(String name,String companyName,String regionName,
                                              int pageCurrent,int pageSize);

    public int queryCustomerCount(String name,String companyName,String regionName);

    public CustomerVo queryCustomer(Long id);

    public boolean addCustomer(CustomerDto customerDto);

    public boolean updateCustomer(CustomerDto customerDto);
    //逻辑删除单位
    public boolean deleteCustomerLogic(List<Long> idList);

}
