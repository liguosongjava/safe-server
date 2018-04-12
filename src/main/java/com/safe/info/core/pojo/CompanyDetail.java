package com.safe.info.core.pojo;

/**
 * 单位详情
 */
public class CompanyDetail extends Company{
    private String regionName;
    private String createCustomerName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCreateCustomerName() {
        return createCustomerName;
    }

    public void setCreateCustomerName(String createCustomerName) {
        this.createCustomerName = createCustomerName;
    }
}
