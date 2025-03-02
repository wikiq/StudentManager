package com.wangpeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取请求的路径
        String uri = String.valueOf(req.getRequestURI());
        String contextPath = req.getContextPath();
        String basePath = uri.substring(contextPath.length());
        // System.out.println("basePath=" + basePath);

        // 如果是登录相关的界面和接口，直接放行
        if (basePath.equals("/index.jsp") || basePath.equals("/login/login.do")) {
            // 访问目标资源
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        // 获得登录对象
        Object loginObj = req.getSession().getAttribute("loginObj");

        // 如果没有登录，则回到登录界面
        if (loginObj == null) {
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }

        // 获得权限身份
        String authority = (String) req.getSession().getAttribute("authority");

        // 如果是管理员身份，直接放行（管理员能访问所有的资源）
        if (authority.equals("manager")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        // 租户允许访问的地址的正则表达式表
        String[] studentPassRegex = {
                "\\/student\\/.+\\.jsp",        // 租户界面
                "\\/.+\\/student\\/.+\\.do",    // 租户接口
                "\\/common\\/password\\.jsp",   // 修改密码界面
                "\\/login\\/alterPassword\\.do" // 修改密码接口
        };

        // 化妆师允许访问的地址的正则表达式表
        String[] teacherPassRegex = {
                "\\/teacher\\/.+\\.jsp",        // 化妆师界面
                "\\/.+\\/teacher\\/.+\\.do",    // 化妆师接口
                "\\/common\\/password\\.jsp",   // 修改密码界面
                "\\/login\\/alterPassword\\.do" // 修改密码接口
        };

        // 如果登录的是租户
        if(authority.equals("student")) {
            for (String regex : studentPassRegex) {
                if (basePath.matches(regex)) {  // 匹配上了，放行
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
            // 没匹配上，回到登录界面
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }

        // 如果登录的是化妆师
        if(authority.equals("teacher")) {
            for (String regex : teacherPassRegex) {
                if (basePath.matches(regex)) {  // 匹配上了，放行
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
            // 没匹配上，回到登录界面
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
