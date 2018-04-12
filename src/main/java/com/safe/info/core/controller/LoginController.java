package com.safe.info.core.controller;

import com.safe.info.core.service.CustomerService;
import com.safe.info.core.util.RandomValidateCodeUtil;
import com.safe.info.core.util.SessionLocal;
import com.safe.info.core.vo.ExecuteResult;
import com.safe.info.core.vo.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登陆控制器
 */
@Controller
public class LoginController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/login")
    public String login(@RequestParam Map<String, String> form, ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/dologin")
    @ResponseBody
    public String dologin(@RequestParam Map<String, String> form,HttpServletRequest httpServletRequest,
                          HttpServletResponse response, ModelMap model) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String captcha = httpServletRequest.getParameter("captcha");
        String random = (String)httpServletRequest.getSession().getAttribute(
                RandomValidateCodeUtil.RANDOMCODEKEY);
        if (random == null) {
            return ExecuteResult.jsonReturn(300,"验证码不合法");
        }
        if (!random.equals(captcha)) {
            return ExecuteResult.jsonReturn(300,"验证码不正确");
        }
        //移除验证码
        httpServletRequest.getSession().removeAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        String ip = this.getIpAddress(httpServletRequest);
        LoginInfo loginInfo = customerService.login(username,password,ip);
        if(loginInfo == null || loginInfo.getCode()!=0){
            return ExecuteResult.jsonReturn(300,loginInfo.getMsg());
        }
        httpServletRequest.getSession().setAttribute("SAFESESSIONID", loginInfo);
        return ExecuteResult.jsonReturn(200);
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().removeAttribute("SAFESESSIONID");
        return ExecuteResult.jsonReturn(200);
    }

    @RequestMapping(value = "/changepwd")
    public String changepwd(@RequestParam Map<String, String> form, ModelMap model) {
        LoginInfo loginInfo = SessionLocal.getUser();
        model.put("customerId",loginInfo.getCustomerId());
        model.put("userName",loginInfo.getName());
        model.put("loginNo",loginInfo.getLoginNo());
        return "changepwd";
    }

    @RequestMapping(value = "/save_pwd")
    @ResponseBody
    public String savePwd(HttpServletRequest request,ModelMap model) {
        LoginInfo loginInfo = SessionLocal.getUser();
        boolean flag = customerService.changepwd(loginInfo.getCustomerId(),null);
        if (flag){
            return ExecuteResult.jsonReturn(200);
        }else {
            return ExecuteResult.jsonReturn(300,"修改密码失败");
        }
    }

    @RequestMapping(value = "/login_timeout")
    public String loginTimeout(@RequestParam Map<String, String> form, ModelMap model) {
        return "login_timeout";
    }
    //获取验证码
    @RequestMapping(value = "/get_code")
    public void getCode(HttpServletRequest request,HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>", e);
        }
    }
}
