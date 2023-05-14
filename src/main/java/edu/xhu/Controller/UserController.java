package edu.xhu.Controller;

import edu.xhu.common.R;
import edu.xhu.pojo.User;
import edu.xhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys_user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public R login(User user){

        return userService.login(user);

    }


}
