package com.safe.info.core.pojo;

import java.util.Date;

/**
 * 房产数据
 */
public class HouseProperty extends BasePojo{
    /** 房产查询号 */
    private String queryNo;
    /** 房产证号 */
    private String certificatesNo;
    /** 权属人身份证号 */
    private String hasIdNo;
    /** 产权人姓名 */
    private String hasName;
    /** 学生姓名 */
    private String studentName;
    /** 共有人 */
    private String sharePeople;
    /** 房产街道 */
    private String houseStreet;
    /** 房产地址 */
    private String houseAddress;
    /** 发证时间 */
    private Date obtainTime;
    /** 校验次数 */
    private Long checkNumber;
    /** 单位备注 */
    private String remark;
    /** 创建人id */
    private Long createCustomer;

    public String getQueryNo() {
        return queryNo;
    }

    public void setQueryNo(String queryNo) {
        this.queryNo = queryNo;
    }

    public String getCertificatesNo() {
        return certificatesNo;
    }

    public void setCertificatesNo(String certificatesNo) {
        this.certificatesNo = certificatesNo;
    }

    public String getHasIdNo() {
        return hasIdNo;
    }

    public void setHasIdNo(String hasIdNo) {
        this.hasIdNo = hasIdNo;
    }

    public String getHasName() {
        return hasName;
    }

    public void setHasName(String hasName) {
        this.hasName = hasName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSharePeople() {
        return sharePeople;
    }

    public void setSharePeople(String sharePeople) {
        this.sharePeople = sharePeople;
    }

    public String getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(String houseStreet) {
        this.houseStreet = houseStreet;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Date getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(Date obtainTime) {
        this.obtainTime = obtainTime;
    }

    public Long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
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
}
