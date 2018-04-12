package com.safe.info.core.pojo;

/**
 * 用户信息表
 */
public class Customer extends BasePojo {
    private String name;
    private String loginNo;
    /**
     * password认为是一个单词，不走驼峰命名了
     */
    private String password;

    private Integer sex;

    private Long regionId;

    private Long companyId;

    private Long createCustomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCreateCustomer() {
        return createCustomer;
    }

    public void setCreateCustomer(Long createCustomer) {
        this.createCustomer = createCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", regionId=" + regionId +
                ", companyId=" + companyId +
                '}';
    }
}
