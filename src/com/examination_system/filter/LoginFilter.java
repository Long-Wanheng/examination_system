package com.examination_system.filter;

import com.examination_system.utils.LogUtil;
import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program examination-system
 * @description: 登陆过滤器
 * @author: yao
 * @create: 2020/11/27 21:43
 */
public class LoginFilter implements Filter {
    private static final Logger LOGGER = LogUtil.getLogger();

    /**
     * 保存不拦截的url
     */
    private static List<String> passUrls = new ArrayList<>();

    /**
     * 上下文
     */
    private String ctxPath = null;

    /**
     * 重定向url
     */
    private static String redirectUrl = "/login.jsp";


    /**
     * 过滤器初始化方法
     *
     * @param filterConfig filterConfig
     * @throws ServletException ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 获取web.xml中的初始化参数
        String ignoreURL = filterConfig.getInitParameter("passURL");
        redirectUrl = filterConfig.getInitParameter("redirectURL");
        // 保存不拦截的url
        String[] ignoreURLArray = ignoreURL.split(",");
        for (String url : ignoreURLArray) {
            passUrls.add(url.trim());
        }
        ctxPath = filterConfig.getServletContext().getContextPath();
        System.out.println("ctx = " + ctxPath);
        LOGGER.info("不拦截的URL包括:");
        for (String url : passUrls) {
            LOGGER.info(url);
        }
    }


    /**
     * 过滤器方法
     *
     * @param servletRequest  request
     * @param servletResponse response
     * @param filterChain     filterChain
     * @throws IOException      I/O异常
     * @throws ServletException ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 请求的url
        String url = request.getRequestURI();
        // 相对路径
        String subUrl = url.substring(ctxPath.length() + 1);

        for (String urlStr : passUrls) {
            // 如果匹配, 则放行
            if (subUrl.indexOf(urlStr) > -1) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        // 获得session
        HttpSession session = request.getSession();
        // 从session中获取SessionKey对应值,若值不存在,则重定向到redirectUrl
        Object user = session.getAttribute("");
        if (user != null) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(ctxPath + "/" + redirectUrl);
        }
    }


    /**
     * 销毁方法
     */
    @Override
    public void destroy() {

    }
}