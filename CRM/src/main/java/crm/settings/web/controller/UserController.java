package crm.settings.web.controller;

import crm.settings.domain.User;
import crm.settings.service.UserService;
import crm.settings.service.impl.UserServiceImpl;
import crm.utils.MD5Util;
import crm.utils.PrintJson;
import crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入用户控制器");
        String path=request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xxx.do".equals(path)){

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入验证登录操作");
        String loginAct=request.getParameter("loginAct");
        String loginPwd=request.getParameter("loginPwd");
        //MD5加密
        loginPwd= MD5Util.getMD5(loginPwd);
        //浏览器ip地址
        String ip=request.getRemoteAddr();
        //调用service层 同时添加代理对象 增加事务功能
        UserService us=(UserService)ServiceFactory.getService(new UserServiceImpl());

        try{
            User user=us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            //登录成功 添加success:true json串到response中
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e){
            e.printStackTrace();
            //登录失败
            String msg=e.getMessage();
            //打包成map 转化为json串【若该需求使用较少】 或 封装成 Vo (success,msg) 【若该需求大量使用】
            Map<String,Object> map=new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);

        }
    }
}
