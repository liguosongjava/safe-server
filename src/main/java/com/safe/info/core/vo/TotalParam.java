package com.safe.info.core.vo;

/**
 * 数据列表查询参数
 */
public class TotalParam {
    private String regionName;
    private String companyName;
    private String studentName;
    private String studentIdNo;
    private Integer declareType;
    private Integer declareGrade;
    private Integer auditStatus;

    public TotalParam(){}

    public TotalParam(String regionName, String companyName,
                      String studentName, String studentIdNo,
                      Integer declareType, Integer declareGrade,
                      Integer auditStatus) {
        this.regionName = regionName;
        this.companyName = companyName;
        this.studentName = studentName;
        this.studentIdNo = studentIdNo;
        this.declareType = declareType;
        this.declareGrade = declareGrade;
        this.auditStatus = auditStatus;

    }

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentIdNo() {
        return studentIdNo;
    }

    public void setStudentIdNo(String studentIdNo) {
        this.studentIdNo = studentIdNo;
    }

    public Integer getDeclareType() {
        return declareType;
    }

    public void setDeclareType(Integer declareType) {
        this.declareType = declareType;
    }

    public Integer getDeclareGrade() {
        return declareGrade;
    }

    public void setDeclareGrade(Integer declareGrade) {
        this.declareGrade = declareGrade;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

}
