package crm.settings.service.impl;

import crm.exception.LoginException;
import crm.settings.dao.UserDao;
import crm.settings.domain.User;
import crm.settings.service.UserService;
import crm.utils.DateTimeUtil;
import crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userdao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,String> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);

        User user=userdao.login(map);

        if(user==null){
            throw new LoginException("账号或密码错误");
        }
        //账号密码正确 继续验证
        //失效时间
        String expireTime=user.getExpireTime();
        String currentTime= DateTimeUtil.getSysTime();
        if(currentTime.compareTo(expireTime)>0){
            throw new LoginException("账号已失效");
        }
        //锁定状态
        String lockState=user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定，请联系管理员");
        }
        //ip地址
        String allowIps=user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginException("ip地址受限");
        }
        return user;
    }
}
