package com.safe.info.core.pojo;

/**
 * 户籍
 */
public class HouseholdRegister extends BasePojo{
    /** 地区名称 */
    private String name;
    /** 户籍地址 */
    private String address;
    /** 单位电话 */
    private String idNo;
    /** 性别 */
    private Long sex;
    /** 发证机关(派出所） */
    private String issuingCompany;
    /** 居委会 */
    private String juweiHui;
    /** 居委会或街道 */
    private String villageStreet;
    /** 父亲 */
    private String father;
    /** 母亲 */
    private String mother;
    /** 其他监护人 */
    private String otherGuardian;
    /** 校验次数 */
    private Long checkNumber;
    /** 单位备注 */
    private String remark;
    /** 创建人id */
    private Long createCustomer;

    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getIssuingCompany() {
        return issuingCompany;
    }

    public void setIssuingCompany(String issuingCompany) {
        this.issuingCompany = issuingCompany;
    }

    public String getJuweiHui() {
        return juweiHui;
    }

    public void setJuweiHui(String juweiHui) {
        this.juweiHui = juweiHui;
    }

    public String getVillageStreet() {
        return villageStreet;
    }

    public void setVillageStreet(String villageStreet) {
        this.villageStreet = villageStreet;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getOtherGuardian() {
        return otherGuardian;
    }

    public void setOtherGuardian(String otherGuardian) {
        this.otherGuardian = otherGuardian;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
