package crm.filter;

import crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入验证是否登录过滤器");
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;

        String path=req.getServletPath();

        if("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){//放行的资源
            chain.doFilter(request,response);
        }else {
            HttpSession session=req.getSession();
            User user=(User)session.getAttribute("user");

            if(user!=null){
                chain.doFilter(request,response);
            }else{//重定向到登录页
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }
        }
    }
}
