package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.vo.PageConditionVo;
import site.liuming.truismcms.web.pojo.User;
import site.liuming.truismcms.web.service.UserService;
import site.liuming.truismcms.vo.LoginUserVo;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户操作接口", tags = {"用户操作接口"})
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public UnifyResponse<LoginUserVo> login(@RequestBody User user) {
        return userService.login(user);
    }


    @PostMapping("/logout")
    public UnifyResponse logout(User user) {
        return UnifyResponseFactory.success("退出成功");
    }

    @PostMapping("/list")
    public UnifyResponse<PagePojoDto<User>> getUserList(@RequestBody PageConditionVo<User> pcv) {
        return userService.getUserList(pcv);
    }

    @PostMapping("/")
    public UnifyResponse<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/")
    public UnifyResponse<String> updateUserById(@RequestBody User user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteUserById(@PathVariable("id") Long userId) {
        return userService.deleteUserById(userId);
    }

}
