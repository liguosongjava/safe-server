package com.safe.info.core.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.safe.info.core.mapper.CustomerMapper;
import com.safe.info.core.mapper.LoginLogMapper;
import com.safe.info.core.pojo.Customer;
import com.safe.info.core.pojo.CustomerDetail;
import com.safe.info.core.pojo.LoginLog;
import com.safe.info.core.service.CustomerService;
import com.safe.info.core.vo.CustomerDto;
import com.safe.info.core.vo.CustomerVo;
import com.safe.info.core.util.DateUtil;
import com.safe.info.core.vo.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    public static String ACCOUNT_DOES_NOT_EXISTS = "登陆帐号不存在！";
    public static String PASSWORD_ERROR = "密码错误！";
    public static String LOGIN_SYSTEM_ERROR = "您的登录信息异常，请联系嘉联管理员！";
    public static String INVALID_ACCOUNT = "无效的登陆帐号！";
    public static String ACCOUNT_BE_BANNED = "该账号已被禁用,无法登陆！";

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public LoginInfo login(String loginNo, String password,String ip) {
        logger.info("login,mobile:{},password:{}",loginNo,password);
        LoginInfo loginInfo = new LoginInfo();
        //校验参数
        if(loginNo == null || password == null){
            loginInfo.setCode(-1);
            loginInfo.setMsg(INVALID_ACCOUNT);
            return loginInfo;
        }
        Customer customer = customerMapper.selectCustomerByLoginNo(loginNo);
        if(customer == null){
            loginInfo.setCode(-1);
            loginInfo.setMsg(ACCOUNT_DOES_NOT_EXISTS);
            return loginInfo;
        }
        if(customer.getState() == 2){
            loginInfo.setCode(-1);
            loginInfo.setMsg(ACCOUNT_BE_BANNED);
            return loginInfo;
        }
        if(!StringUtils.equalsIgnoreCase(password, customer.getPassword())){
            loginInfo.setCode(-1);
            loginInfo.setMsg(PASSWORD_ERROR);
            return loginInfo;
        }
        //添加登录记录
        LoginLog loginLog = new LoginLog(customer.getId(),ip,new Date(),1);
        loginLogMapper.insert(loginLog);
        loginInfo.setCustomerId(customer.getId());
        loginInfo.setName(customer.getName());
        loginInfo.setLoginNo(customer.getLoginNo());
        return loginInfo;
    }

    @Override
    public boolean changepwd(Long customerId, String newPwd) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setState(1);
        customer.setPassword(newPwd);
        int updateNum = customerMapper.update(customer);
        return updateNum<1?false:true;
    }

    @Override
    public List<CustomerVo> queryCustomerPage(String name,String companyName,String regionName,
                                              int pageCurrent,int pageSize) {
        int start = (pageCurrent-1)*pageSize;
        List<CustomerDetail> cuList = customerMapper.queryCustomerPage(name,companyName,regionName,
                start,pageSize);
        List<CustomerVo> pageList = new ArrayList<>();
        for(CustomerDetail customerDetail : cuList){
            CustomerVo customerVo = new CustomerVo();
            customerVo.setId(customerDetail.getId());
            customerVo.setName(customerDetail.getName());
            customerVo.setLoginNo(customerDetail.getLoginNo());
            customerVo.setSex(customerDetail.getSex()==0?true:false);
            customerVo.setRegionId(customerDetail.getRegionId());
            customerVo.setRegionName(customerDetail.getRegionName());
            customerVo.setCompanyId(customerDetail.getCompanyId());
            customerVo.setCompanyName(customerDetail.getCompanyName());
            customerVo.setCreateCustomer(customerDetail.getCreateCustomer());
            customerVo.setCreateCustomerName(customerDetail.getCreateCustomerName());
            customerVo.setCompanyName(customerDetail.getCompanyName());
            String createTime = null;
            try {
                createTime = DateUtil.parseTime(customerDetail.getCreateTime(),DateUtil.SP1);
            } catch (ParseException e) {
                logger.info("parseTime error,id:{}",customerDetail.getId());
            }
            customerVo.setCreateTime(createTime);
            pageList.add(customerVo);
        }
        return pageList;
    }

    @Override
    public int queryCustomerCount(String name, String companyName, String regionName) {
        return customerMapper.queryCustomerCount(name,companyName,regionName);
    }

    @Override
    public CustomerVo queryCustomer(Long id) {
        CustomerDetail customerDetail = customerMapper.queryCustomer(id);
        CustomerVo customerVo = new CustomerVo();
        customerVo.setId(customerDetail.getId());
        customerVo.setName(customerDetail.getName());
        customerVo.setLoginNo(customerDetail.getLoginNo());
        customerVo.setSex(customerDetail.getSex()==0?true:false);
        customerVo.setRegionId(customerDetail.getRegionId());
        customerVo.setRegionName(customerDetail.getRegionName());
        customerVo.setCompanyId(customerDetail.getCompanyId());
        customerVo.setCompanyName(customerDetail.getCompanyName());
        customerVo.setCreateCustomer(customerDetail.getCreateCustomer());
        customerVo.setCreateCustomerName(customerDetail.getCreateCustomerName());
        customerVo.setCompanyName(customerDetail.getCompanyName());
        String createTime = null;
        try {
            createTime = DateUtil.parseTime(customerDetail.getCreateTime(),DateUtil.SP1);
        } catch (ParseException e) {
            logger.info("parseTime error,id:{}",customerDetail.getId());
        }
        customerVo.setCreateTime(createTime);
        return customerVo;
    }

    @Override
    public boolean addCustomer(CustomerDto customerDto) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        return false;
    }

    @Override
    public boolean deleteCustomerLogic(List<Long> idList) {
        for(Long id : idList){
            Customer customer = new Customer();
            customer.setId(id);
            customer.setState(0);
            customerMapper.update(customer);
        }
        return true;
    }


}
