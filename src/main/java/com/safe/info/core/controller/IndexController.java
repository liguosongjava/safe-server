package com.safe.info.core.controller;

import com.alibaba.fastjson.JSON;
import com.safe.info.core.util.SessionLocal;
import com.safe.info.core.vo.LoginInfo;
import com.safe.info.core.vo.MenuVo;
import com.safe.info.core.vo.MenusVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页控制器
 */
@Controller
public class IndexController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/index")
    public String index(ModelMap model){
        LoginInfo loginInfo = SessionLocal.getUser();
        model.put("userName",loginInfo.getName());
        model.put("loginNo",loginInfo.getLoginNo());
        return "index";
    }
    //TODO 后期加入权限过滤菜单。从数据库查询
    @RequestMapping("/memu_json")
    @ResponseBody
    public String memuJson(){
        logger.info("login index");
        List<MenusVo> menus = new ArrayList<>();
        MenusVo userMenus = new MenusVo();
        menus.add(userMenus);
        userMenus.setName("用户管理");
        MenuVo userMenu =  new MenuVo("user-col",
                "用户列表","navtab","/customer/list");
        List<MenuVo> menu = new ArrayList<>();
        menu.add(userMenu);
        MenusVo dataMenus = new MenusVo();
        menus.add(dataMenus);
        dataMenus.setName("资料导入");
        MenuVo dataMenu1 =  new MenuVo("hreg-col",
                "户籍数据导入","navtab","/data_import/house_register");
        MenuVo dataMenu2 =  new MenuVo("hpro-col",
                "房产数据导入","navtab","/data_import/house_pro");
        List<MenuVo> menu1 = new ArrayList<>();
        menu1.add(dataMenu1);menu1.add(dataMenu2);
        MenusVo dataMenus1 = new MenusVo();
        menus.add(dataMenus1);
        dataMenus1.setName("资料管理");
        MenuVo dataMenu11 =  new MenuVo("data_panel",
                "资料列表","navtab","/totalData/list");
        MenuVo dataMenu21 =  new MenuVo("region_panel",
                "地区列表","navtab","/region/list");
        MenuVo dataMenu31 =  new MenuVo("company_panel",
                "单位列表","navtab","/company/list");
        List<MenuVo> menu2 = new ArrayList<>();
        menu2.add(dataMenu11);menu2.add(dataMenu21);menu2.add(dataMenu31);
        userMenus.setChildren(menu);
        dataMenus.setChildren(menu1);
        userMenus.setChildren(menu);
        dataMenus1.setChildren(menu2);
        return JSON.toJSONString(menus);
    }
}
