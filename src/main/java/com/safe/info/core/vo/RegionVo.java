package com.safe.info.core.vo;


public class RegionVo {
    private Long id;
    private String name;
    private String remark;
    private String createCustomer;
    private String createTime;

    public RegionVo() {
    }

    public RegionVo(String createTime, Long id, String name, String remark, String createCustomer) {
        this.createTime = createTime;
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.createCustomer = createCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateCustomer() {
        return createCustomer;
    }

    public void setCreateCustomer(String createCustomer) {
        this.createCustomer = createCustomer;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
