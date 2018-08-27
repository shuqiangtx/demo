package com.winter.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

/**
 * Created by Administrator on 2018-08-24.
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class FilterRegistrationBean implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("MyFilter init............");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("入参：");
        System.out.println("MyFilter doFilter.........before");
        chain.doFilter(request, response);
        System.out.println("MyFilter doFilter.........after");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy..........");
    }

}
