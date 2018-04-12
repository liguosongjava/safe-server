package com.safe.info.core.mapper;

import com.safe.info.core.pojo.Customer;
import com.safe.info.core.pojo.CustomerDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息mapper
 */
public interface CustomerMapper {

    public Customer selectCustomerById(Long customerId);

    public Customer selectCustomerByLoginNo(String loginNo);

    public int insert(Customer customer);

    public int update(Customer customer);

    public List<CustomerDetail> queryCustomerPage(@Param("name") String name,
                                                  @Param("companyName")String companyName,
                                                  @Param("regionName")String regionName,
                                                  @Param("start")int start,
                                                  @Param("pageNum")int pageNum);

    public int queryCustomerCount(@Param("name") String name,
                                   @Param("companyName")String companyName,
                                   @Param("regionName")String regionName);

    public CustomerDetail queryCustomer(Long id);
}
