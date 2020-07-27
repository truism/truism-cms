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
import site.liuming.truismcms.web.mapper.TagMapper;
import site.liuming.truismcms.web.pojo.Tag;
import site.liuming.truismcms.web.pojo.TagExample;

import java.util.List;
import java.util.Objects;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 获取标签列表
     * @param pageNum
     * @param pageSize
     * @param tagName
     * @return
     */
    public PagePojoDto<Tag> getTagList(Integer pageNum, Integer pageSize, String tagName) {
        PageHelper.startPage(pageNum, pageSize);
        TagExample example = new TagExample();
        if(Objects.nonNull(tagName) || !StringUtils.isEmpty(tagName)) {
            example.createCriteria().andNameEqualTo(tagName);
        }
        List<Tag> tagList = tagMapper.selectByExample(example);
        PagePojoDto dto = new PagePojoDto();
        dto.setTotal((long) tagList.size());
        dto.setPageNum(pageNum);
        dto.setPageSize(pageSize);
        dto.setData(tagList);
        return dto;
    }

    /**
     * 根据id获取标签
     * @param tagId
     * @return
     */
    public UnifyResponse<Tag> getTagById(Long tagId) {
        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        if(Objects.nonNull(tag)) {
            return UnifyResponseFactory.success(tag);
        }
        throw new NotFoundException(7001);
    }

    /**
     * 增加标签
     * @param tag
     * @return
     */
    @Transactional
    public UnifyResponse<String> addTag(Tag tag) {
        return tagMapper.insert(tag) > 0 ? UnifyResponseFactory.success("添加成功") : UnifyResponseFactory.fail("添加失败");
    }

    /**
     * 更新标签
     * @param tag
     * @return
     */
    @Transactional
    public UnifyResponse<String>  updateTag(Tag tag) {
        return tagMapper.updateByPrimaryKey(tag) > 0 ? UnifyResponseFactory.success("更新成功") : UnifyResponseFactory.fail("更新失败");
    }

    /**
     * 删除标签
     * @param tagId
     * @return
     */
    @Transactional
    public UnifyResponse<String> deleteTagById(Long tagId) {
        return tagMapper.deleteByPrimaryKey(tagId) > 0 ? UnifyResponseFactory.success("删除成功") : UnifyResponseFactory.fail("删除失败");
    }

}
