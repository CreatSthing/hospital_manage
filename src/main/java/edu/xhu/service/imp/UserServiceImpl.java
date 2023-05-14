package edu.xhu.service.imp;

import edu.xhu.common.R;
import edu.xhu.mapper.USerMapper;
import edu.xhu.pojo.User;
import edu.xhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private USerMapper USerMapper;

    @Override
    public R login(User user) {
        R r=new R();
        User reuser = USerMapper.login(user);
        if(reuser!=null){
            r.setData(reuser);
            r.setCode(200);
            r.setMsg("登录成功");

        }else{
            r.setCode(500);
            r.setMsg("用户名或者密码有误");
        }
        return r;


    }
}
