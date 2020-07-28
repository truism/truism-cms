package site.liuming.truismcms.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.exceptions.ForbiddenUpdateException;
import site.liuming.truismcms.exceptions.NotFoundException;
import site.liuming.truismcms.web.mapper.TypeMapper;
import site.liuming.truismcms.web.pojo.Type;
import site.liuming.truismcms.web.pojo.TypeExample;

import java.util.List;
import java.util.Objects;

@Service
public class TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 获取type列表
     * @param name
     * @return
     */
    public UnifyResponse<List<Type>> getTypeList(String name) {
        TypeExample example = new TypeExample();
        example.createCriteria().andNameLike("%" + name + "%");
        List<Type> typeList = typeMapper.selectByExample(example);
        return UnifyResponseFactory.success(typeList);
    }

    /**
     * 根据id获取type
     * @param id
     * @return
     */
    public UnifyResponse<Type> getTypeById(Long id) {
        Type type = typeMapper.selectByPrimaryKey(id);
        if(Objects.nonNull(type)) {
            return UnifyResponseFactory.success(type);
        }
        throw new NotFoundException(9001);
    }


    /**
     * 添加type
     * @param type
     * @return
     */
    @Transactional
    public UnifyResponse<String> addType(Type type) {
        TypeExample example = new TypeExample();
        example.createCriteria().andNameEqualTo(type.getName());
        List<Type> temp = typeMapper.selectByExample(example);
        if(Objects.nonNull(temp) && temp.size() > 0) {
            return UnifyResponseFactory.fail("新增失败,名称已存在");
        }
        return typeMapper.insert(type) > 0 ? UnifyResponseFactory.success("新增成功") : UnifyResponseFactory.fail("新增失败");
    }

    /**
     * 更新type
     * @param type
     * @return
     */
    @Transactional
    public UnifyResponse<String> updateType(Type type) {
        Type temp = typeMapper.selectOther(type);
        if(Objects.nonNull(temp)) {
            throw new ForbiddenUpdateException(5001);
        }
        return typeMapper.updateByPrimaryKey(type) > 0 ? UnifyResponseFactory.success("更新成功") : UnifyResponseFactory.fail("更新失败");
    }


    /**
     * 删除type
     * @param id
     * @return
     */
    @Transactional
    public UnifyResponse<String> deleteType(Long id) {
        return typeMapper.deleteByPrimaryKey(id) > 0 ? UnifyResponseFactory.success("删除成功") : UnifyResponseFactory.fail("删除失败");
    }


    /**
     * 获取所有type
     * @return
     */
    public UnifyResponse<List<Type>> getAll() {
        List<Type> typeList = typeMapper.selectAll();
        return UnifyResponseFactory.success(typeList);
    }
}
