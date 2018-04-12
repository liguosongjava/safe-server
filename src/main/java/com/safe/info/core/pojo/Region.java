package com.safe.info.core.pojo;

import java.util.Date;

/**
 * 地区
 */
public class Region extends BasePojo{
    private String name;
    private String remark;
    private Long createCustomer;

    public Region(){

    }

    public Region(String name, String remark,Long createCustomer) {
        this.name = name;
        this.remark = remark;
        this.createCustomer = createCustomer;
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

    public Long getCreateCustomer() {
        return createCustomer;
    }

    public void setCreateCustomer(Long createCustomer) {
        this.createCustomer = createCustomer;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createCustomer=" + createCustomer +
                '}';
    }
}
