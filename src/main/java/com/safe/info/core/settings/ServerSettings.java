package com.safe.info.core.settings;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "core")
public class ServerSettings {
    private String houseRegImportPath;

    private String houseProImportPath;



    public String getHouseRegImportPath() {
        return houseRegImportPath;
    }

    public void setHouseRegImportPath(String houseRegImportPath) {
        this.houseRegImportPath = houseRegImportPath;
    }

    public String getHouseProImportPath() {
        return houseProImportPath;
    }

    public void setHouseProImportPath(String houseProImportPath) {
        this.houseProImportPath = houseProImportPath;
    }
}
