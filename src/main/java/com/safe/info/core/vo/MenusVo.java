package com.safe.info.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单json数据
 */
public class MenusVo implements Serializable {
    private String name;
    private List<MenuVo> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }

}
