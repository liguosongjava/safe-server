package com.safe.info.core.pojo;


public class CustomerDetail extends Customer{
    private String regionName;
    private String companyName;
    private String createCustomerName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreateCustomerName() {
        return createCustomerName;
    }

    public void setCreateCustomerName(String createCustomerName) {
        this.createCustomerName = createCustomerName;
    }
}
