package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.web.pojo.User;
import site.liuming.truismcms.web.service.UserService;
import site.liuming.truismcms.vo.LoginUserVo;

@RestController
@RequestMapping("/user")
@Api(value = "用户操作接口", tags = {"用户接口"})
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录")
    @ApiImplicitParam(name = "user", value = "用户", required = true)
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
