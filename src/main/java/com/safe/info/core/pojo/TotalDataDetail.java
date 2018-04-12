package com.safe.info.core.pojo;

import java.util.Date;

/**
 *总数据表
 */
public class TotalDataDetail extends TotalData{
    private String regionName;
    private String companyName;
    private String applyCustomerName;
    //房产相关
    /** 房产查询号 */
    private String hpQueryNo;
    /** 房产证号 */
    private String hpCertificatesNo;
    /** 权属人身份证号 */
    private String hpHasIdNo;
    /** 产权人姓名 */
    private String hpHasName;
    /** 学生姓名 */
    private String hpStudentName;
    /** 共有人 */
    private String hpSharePeople;
    /** 房产街道 */
    private String hpHouseStreet;
    /** 房产地址 */
    private String hpHouseAddress;
    /** 发证时间 */
    private Date hpObtainTime;
    //户籍相关
    /** 名称 */
    private String hrName;
    /** 户籍地址 */
    private String hrAddress;
    /** 单位电话 */
    private String hrIdNo;
    /** 性别 */
    private Long hrSex;
    /** 发证机关(派出所） */
    private String hrIssuingCompany;
    /** 居委会 */
    private String hrJuweiHui;
    /** 村委会或街道 */
    private String hrVillageStreet;
    /** 父亲 */
    private String hrFather;
    /** 母亲 */
    private String hrMother;
    /** 其他监护人 */
    private String hrOtherGuardian;

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

    public String getApplyCustomerName() {
        return applyCustomerName;
    }

    public void setApplyCustomerName(String applyCustomerName) {
        this.applyCustomerName = applyCustomerName;
    }

    public String getHpQueryNo() {
        return hpQueryNo;
    }

    public void setHpQueryNo(String hpQueryNo) {
        this.hpQueryNo = hpQueryNo;
    }

    public String getHpCertificatesNo() {
        return hpCertificatesNo;
    }

    public void setHpCertificatesNo(String hpCertificatesNo) {
        this.hpCertificatesNo = hpCertificatesNo;
    }

    public String getHpHasIdNo() {
        return hpHasIdNo;
    }

    public void setHpHasIdNo(String hpHasIdNo) {
        this.hpHasIdNo = hpHasIdNo;
    }

    public String getHpHasName() {
        return hpHasName;
    }

    public void setHpHasName(String hpHasName) {
        this.hpHasName = hpHasName;
    }

    public String getHpStudentName() {
        return hpStudentName;
    }

    public void setHpStudentName(String hpStudentName) {
        this.hpStudentName = hpStudentName;
    }

    public String getHpSharePeople() {
        return hpSharePeople;
    }

    public void setHpSharePeople(String hpSharePeople) {
        this.hpSharePeople = hpSharePeople;
    }

    public String getHpHouseStreet() {
        return hpHouseStreet;
    }

    public void setHpHouseStreet(String hpHouseStreet) {
        this.hpHouseStreet = hpHouseStreet;
    }

    public String getHpHouseAddress() {
        return hpHouseAddress;
    }

    public void setHpHouseAddress(String hpHouseAddress) {
        this.hpHouseAddress = hpHouseAddress;
    }

    public Date getHpObtainTime() {
        return hpObtainTime;
    }

    public void setHpObtainTime(Date hpObtainTime) {
        this.hpObtainTime = hpObtainTime;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getHrAddress() {
        return hrAddress;
    }

    public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

    public String getHrIdNo() {
        return hrIdNo;
    }

    public void setHrIdNo(String hrIdNo) {
        this.hrIdNo = hrIdNo;
    }

    public Long getHrSex() {
        return hrSex;
    }

    public void setHrSex(Long hrSex) {
        this.hrSex = hrSex;
    }

    public String getHrIssuingCompany() {
        return hrIssuingCompany;
    }

    public void setHrIssuingCompany(String hrIssuingCompany) {
        this.hrIssuingCompany = hrIssuingCompany;
    }

    public String getHrJuweiHui() {
        return hrJuweiHui;
    }

    public void setHrJuweiHui(String hrJuweiHui) {
        this.hrJuweiHui = hrJuweiHui;
    }

    public String getHrVillageStreet() {
        return hrVillageStreet;
    }

    public void setHrVillageStreet(String hrVillageStreet) {
        this.hrVillageStreet = hrVillageStreet;
    }

    public String getHrFather() {
        return hrFather;
    }

    public void setHrFather(String hrFather) {
        this.hrFather = hrFather;
    }

    public String getHrMother() {
        return hrMother;
    }

    public void setHrMother(String hrMother) {
        this.hrMother = hrMother;
    }

    public String getHrOtherGuardian() {
        return hrOtherGuardian;
    }

    public void setHrOtherGuardian(String hrOtherGuardian) {
        this.hrOtherGuardian = hrOtherGuardian;
    }
}
