package com.safe.info.core.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 权限过滤器
 */
public class SecurityFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
