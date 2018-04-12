package com.safe.info.core.vo;


public class CompanyDto {
    private Long id;
    /** 单位名称 */
    private String name;
    /** 单位地址 */
    private String address;
    /** 单位电话 */
    private String phone;
    /** 所属地区id */
    private Long regionId;
    /** 可申报人数 */
    private Long declareNum;
    /** 申报类型 */
    private String declareType;
    /** 可申报年级 */
    private String declareGrade;
    /** 单位级别 */
    private String companyLevel;
    /** 房产校验内容 */
    private String houseCheck;
    /** 户籍校验内容 */
    private String hregisterCheck;
    /** 单位备注 */
    private String remark;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getDeclareNum() {
        return declareNum;
    }

    public void setDeclareNum(Long declareNum) {
        this.declareNum = declareNum;
    }

    public String getDeclareType() {
        return declareType;
    }

    public void setDeclareType(String declareType) {
        this.declareType = declareType;
    }

    public String getDeclareGrade() {
        return declareGrade;
    }

    public void setDeclareGrade(String declareGrade) {
        this.declareGrade = declareGrade;
    }

    public String getCompanyLevel() {
        return companyLevel;
    }

    public void setCompanyLevel(String companyLevel) {
        this.companyLevel = companyLevel;
    }

    public String getHouseCheck() {
        return houseCheck;
    }

    public void setHouseCheck(String houseCheck) {
        this.houseCheck = houseCheck;
    }

    public String getHregisterCheck() {
        return hregisterCheck;
    }

    public void setHregisterCheck(String hregisterCheck) {
        this.hregisterCheck = hregisterCheck;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
