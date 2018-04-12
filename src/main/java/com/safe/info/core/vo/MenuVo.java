package com.safe.info.core.vo;

import java.io.Serializable;

/**
 * 菜单选项
 */
public class MenuVo implements Serializable {
    private String id;
    private String name;
    private String target;
    private String url;

    public MenuVo() {
    }

    public MenuVo(String id, String name, String target, String url) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
