package com.safe.info.core.filter;

import com.safe.info.core.util.CookieUtils;
import com.safe.info.core.util.SessionLocal;
import com.safe.info.core.vo.ExecuteResult;
import com.safe.info.core.vo.LoginInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTimeoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("X-Frame-Options", "SAMEORIGIN");
        if (uri.startsWith(ctx + "/lib") || uri.startsWith(ctx + "/js") ||
                uri.startsWith(ctx + "/images") || uri.startsWith(ctx + "/css") ||
                uri.startsWith(ctx + "/resources") || uri.startsWith(ctx + "/assets") ||
                uri.startsWith(ctx + "/B-JUI")) {
            chain.doFilter(request, response);
            return;
        }
        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("SAFESESSIONID");
        if (loginInfo == null && !uri.equals(ctx) && !uri.equals(ctx + "/")
                && !uri.contains("logout") && !uri.contains("login") && !uri.contains("dologin")
                && !uri.contains("get_code")) {//未登录或会话超时
            if (isAjaxRequest(req)) {
//                resp.addHeader("sessionstatus", "timeOut");
//                chain.doFilter(request, response);
                try {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(ExecuteResult.jsonReturn(301));
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            } else {
                String str = "<script language='javascript'>alert('会话过期，请重新登录！');"
                        + "window.top.location.href='" + req.getContextPath() + "/login';</script>";
                response.setContentType("text/html;charset=UTF-8");
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        //存储ThreadLocal
        SessionLocal.setUser(loginInfo);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(header) ? true : false;
    }
}
