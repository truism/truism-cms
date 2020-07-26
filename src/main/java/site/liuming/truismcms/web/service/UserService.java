package site.liuming.truismcms.web.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.exceptions.NotFoundException;
import site.liuming.truismcms.utils.JwtToken;
import site.liuming.truismcms.vo.LoginUserVo;
import site.liuming.truismcms.web.mapper.UserMapper;
import site.liuming.truismcms.web.pojo.User;
import site.liuming.truismcms.web.pojo.UserExample;

import java.util.List;
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

    /**
     * 获取 user 列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public UnifyResponse<List<User>> getUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectByExample(new UserExample());
        return UnifyResponseFactory.success(userList);
    }


    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public User getByUserId(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(Objects.nonNull(user)) {
            return user;
        }
        throw new NotFoundException(4001);
    }


    /**
     * 根据 id 更新user
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateById(User user) {
        return userMapper.updateByPrimaryKey(user);
    }


}
