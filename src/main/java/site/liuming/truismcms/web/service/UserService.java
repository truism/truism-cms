package site.liuming.truismcms.web.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.exceptions.NotFoundException;
import site.liuming.truismcms.utils.JwtToken;
import site.liuming.truismcms.vo.LoginUserVo;
import site.liuming.truismcms.vo.PageConditionVo;
import site.liuming.truismcms.web.mapper.UserMapper;
import site.liuming.truismcms.web.pojo.User;
import site.liuming.truismcms.web.pojo.UserExample;

import java.util.Date;
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
     * 获取User 列表
     * 查询参数： username、phone、email、signInTime、valid
     * @param pvo
     * @return
     */
    public UnifyResponse<PagePojoDto<User>> getUserList(PageConditionVo<User> pvo) {
        PagePojoDto<User> result = new PagePojoDto<>();
        PageHelper.startPage(pvo.getPageNum(), pvo.getPageSize());
        User conditionUser = pvo.getParamMap();
        UserExample example = new UserExample();
        String username = conditionUser.getUsername();
        String phone = conditionUser.getPhone();
        String email = conditionUser.getEmail();
        Date signInTime = conditionUser.getSignInTime();
        Boolean valid = conditionUser.getValid();
        UserExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if(!StringUtils.isEmpty(phone)) {
            criteria.andPhoneEqualTo(phone);
        }
        if(!StringUtils.isEmpty(email)) {
            criteria.andEmailEqualTo(email);
        }
        if(Objects.nonNull(signInTime)) {
            criteria.andSignInTimeEqualTo(signInTime);
        }
        if(Objects.nonNull(valid)) {
            criteria.andValidEqualTo(valid);
        }
        List<User> userList = userMapper.selectByExample(example);
        result.setPageNum(pvo.getPageNum());
        result.setPageSize(pvo.getPageSize());
        result.setTotal((long) userList.size());
        result.setData(userList);
        return UnifyResponseFactory.success(result);
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
    public UnifyResponse<String> updateById(User user) {
        Integer count = userMapper.updateByPrimaryKey(user);
        if(count > 0) {
            return UnifyResponseFactory.success("更新成功");
        }
        return UnifyResponseFactory.fail("更新失败");
    }

    /**
     * 根据 id 删除用户
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public UnifyResponse<String> deleteUserById(Long userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0 ? UnifyResponseFactory.success("删除成功") : UnifyResponseFactory.fail("更新失败");
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    public UnifyResponse<String> addUser(User user) {
        return userMapper.insert(user) > 0 ? UnifyResponseFactory.success("新增成功") : UnifyResponseFactory.fail("新增失败");
    }
}
