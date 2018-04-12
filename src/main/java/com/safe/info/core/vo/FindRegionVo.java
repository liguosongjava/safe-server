package com.safe.info.core.vo;


public class FindRegionVo {
    private Long regionId;
    private String regionName;
    private String regionRemark;

    public FindRegionVo(){

    }

    public FindRegionVo(Long regionId, String regionName, String regionRemark) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionRemark = regionRemark;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionRemark() {
        return regionRemark;
    }

    public void setRegionRemark(String regionRemark) {
        this.regionRemark = regionRemark;
    }
}
