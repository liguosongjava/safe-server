package com.safe.info.core.pojo;


import java.util.Date;

public class TotalData extends BasePojo{
    /** 单位id */
    private Long companyId;
    /** 所属地区id */
    private Long regionId;
    /** 房产id */
    private Long houseProId;
    /** 户籍id */
    private Long householdId;
    /** 年级 */
    private Integer grade;
    /** 学籍号 */
    private String schoolNo;
    /** 原学校名 */
    private String originalSchool;
    /** 准考证号 */
    private String examinationNo;
    /** 登记表号 */
    private String registerNo;
    /** 家庭住址 */
    private String homeAddress;
    /** 监护人姓名 */
    private String guardianName;
    /** 监护人类型 */
    private String guardianType;
    /** 监护人电话 */
    private String guardianPhone;
    /** 监护人工作单位 */
    private String guardianUnit;
    /** 登记表编号 */
    private String regFormNumber;
    /** 有效证件z证明地址 */
    private String certificateAddress;
    /** 房产主与该生关系 */
    private String fczRelation;
    /** 户口主与该生关系 */
    private String hkzRelation;
    /** 户口迁入现证日期 */
    private String moveTime;
    /** 语文分数 */
    private Long chineseFraction;
    /** 英语分数 */
    private Long englishFraction;
    /** 思想品德分数 */
    private Long sxpdFraction;
    /** 物理分数 */
    private Long physicsFraction;
    /** 化学分数 */
    private Long chemistryFraction;
    /** 历史分数 */
    private Long historyFraction;
    /** 体育分数 */
    private Long sportsFraction;
    /** 地理分数 */
    private Long geographyFraction;
    /** 生物分数 */
    private String biologyFraction;
    /** 总分 */
    private Long totalFraction;
    /** 总分加 */
    private Long totalFractionAdd;
    /** 总分备注 */
    private String totalFractionRemark;
    /** 备注1 */
    private String remarkOne;
    /** 备注2 */
    private String remarkTwo;
    /** 备注3 */
    private String remarkThree;
    /** 备注4 */
    private String remarkFour;
    /** 到校注册时间 */
    private Date registDate;
    /** 申报人 */
    private Long applyCustomer;
    /** 申报单位 */
    private Long applyCompany;
    /** 申报时间 */
    private Date applyTime;
    /** 审核状态 */
    private Integer auditStatus;
    /** 审核人 */
    private Long auditCustomer;

    private Date auditTime;

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getOriginalSchool() {
        return originalSchool;
    }

    public void setOriginalSchool(String originalSchool) {
        this.originalSchool = originalSchool;
    }

    public String getExaminationNo() {
        return examinationNo;
    }

    public void setExaminationNo(String examinationNo) {
        this.examinationNo = examinationNo;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public String getGuardianUnit() {
        return guardianUnit;
    }

    public void setGuardianUnit(String guardianUnit) {
        this.guardianUnit = guardianUnit;
    }

    public String getRegFormNumber() {
        return regFormNumber;
    }

    public void setRegFormNumber(String regFormNumber) {
        this.regFormNumber = regFormNumber;
    }

    public String getCertificateAddress() {
        return certificateAddress;
    }

    public void setCertificateAddress(String certificateAddress) {
        this.certificateAddress = certificateAddress;
    }

    public String getFczRelation() {
        return fczRelation;
    }

    public void setFczRelation(String fczRelation) {
        this.fczRelation = fczRelation;
    }

    public String getHkzRelation() {
        return hkzRelation;
    }

    public void setHkzRelation(String hkzRelation) {
        this.hkzRelation = hkzRelation;
    }

    public String getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(String moveTime) {
        this.moveTime = moveTime;
    }

    public Long getChineseFraction() {
        return chineseFraction;
    }

    public void setChineseFraction(Long chineseFraction) {
        this.chineseFraction = chineseFraction;
    }

    public Long getEnglishFraction() {
        return englishFraction;
    }

    public void setEnglishFraction(Long englishFraction) {
        this.englishFraction = englishFraction;
    }

    public Long getSxpdFraction() {
        return sxpdFraction;
    }

    public void setSxpdFraction(Long sxpdFraction) {
        this.sxpdFraction = sxpdFraction;
    }

    public Long getPhysicsFraction() {
        return physicsFraction;
    }

    public void setPhysicsFraction(Long physicsFraction) {
        this.physicsFraction = physicsFraction;
    }

    public Long getChemistryFraction() {
        return chemistryFraction;
    }

    public void setChemistryFraction(Long chemistryFraction) {
        this.chemistryFraction = chemistryFraction;
    }

    public Long getHistoryFraction() {
        return historyFraction;
    }

    public void setHistoryFraction(Long historyFraction) {
        this.historyFraction = historyFraction;
    }

    public Long getSportsFraction() {
        return sportsFraction;
    }

    public void setSportsFraction(Long sportsFraction) {
        this.sportsFraction = sportsFraction;
    }

    public Long getGeographyFraction() {
        return geographyFraction;
    }

    public void setGeographyFraction(Long geographyFraction) {
        this.geographyFraction = geographyFraction;
    }

    public String getBiologyFraction() {
        return biologyFraction;
    }

    public void setBiologyFraction(String biologyFraction) {
        this.biologyFraction = biologyFraction;
    }

    public Long getTotalFraction() {
        return totalFraction;
    }

    public void setTotalFraction(Long totalFraction) {
        this.totalFraction = totalFraction;
    }

    public Long getTotalFractionAdd() {
        return totalFractionAdd;
    }

    public void setTotalFractionAdd(Long totalFractionAdd) {
        this.totalFractionAdd = totalFractionAdd;
    }

    public String getTotalFractionRemark() {
        return totalFractionRemark;
    }

    public void setTotalFractionRemark(String totalFractionRemark) {
        this.totalFractionRemark = totalFractionRemark;
    }

    public String getRemarkOne() {
        return remarkOne;
    }

    public void setRemarkOne(String remarkOne) {
        this.remarkOne = remarkOne;
    }

    public String getRemarkTwo() {
        return remarkTwo;
    }

    public void setRemarkTwo(String remarkTwo) {
        this.remarkTwo = remarkTwo;
    }

    public String getRemarkThree() {
        return remarkThree;
    }

    public void setRemarkThree(String remarkThree) {
        this.remarkThree = remarkThree;
    }

    public String getRemarkFour() {
        return remarkFour;
    }

    public void setRemarkFour(String remarkFour) {
        this.remarkFour = remarkFour;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Long getApplyCustomer() {
        return applyCustomer;
    }

    public void setApplyCustomer(Long applyCustomer) {
        this.applyCustomer = applyCustomer;
    }

    public Long getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(Long applyCompany) {
        this.applyCompany = applyCompany;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getAuditCustomer() {
        return auditCustomer;
    }

    public void setAuditCustomer(Long auditCustomer) {
        this.auditCustomer = auditCustomer;
    }

    public Long getHouseProId() {
        return houseProId;
    }

    public void setHouseProId(Long houseProId) {
        this.houseProId = houseProId;
    }

    public Long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Long householdId) {
        this.householdId = householdId;
    }
}
