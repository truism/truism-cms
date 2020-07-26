package site.liuming.truismcms.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.exceptions.NotFoundException;
import site.liuming.truismcms.utils.JwtToken;
import site.liuming.truismcms.vo.LoginUserVo;
import site.liuming.truismcms.web.mapper.UserMapper;
import site.liuming.truismcms.web.pojo.User;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public UnifyResponse<LoginUserVo> login(User user) {
        User existUser = userMapper.selectByName(user);
        if(!Objects.nonNull(existUser)) {
            throw new NotFoundException(4001);
        }
        String token = JwtToken.getToken(existUser);
        LoginUserVo loginUserVo = new LoginUserVo(user, token);
        return UnifyResponseFactory.success(loginUserVo);

    }


}
