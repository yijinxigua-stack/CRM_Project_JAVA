package crm.filter;

import javax.servlet.*;
import java.io.IOException;

public class EcodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入字符编码过滤器");
        //过滤post请求中的中文乱码
        servletRequest.setCharacterEncoding("UTF-8");
        //过滤响应流中的中文乱码
        servletResponse.setContentType("text/html;charset=utf-8");
        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
