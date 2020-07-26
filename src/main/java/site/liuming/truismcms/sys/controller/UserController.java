package site.liuming.truismcms.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.sys.pojo.User;
import site.liuming.truismcms.sys.service.UserService;
import site.liuming.truismcms.vo.LoginUserVo;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public UnifyResponse<LoginUserVo> login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/info/{token}")
    public UnifyResponse<User> getUserInfo(@PathVariable String token) {
        return userService.getUserInfo(token);
    }

    @PostMapping("/logout")
    public UnifyResponse logout() {
        return UnifyResponseFactory.success("退出成功");
    }

}
