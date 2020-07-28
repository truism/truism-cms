package site.liuming.truismcms.web.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.liuming.truismcms.bo.BlogBo;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.exceptions.NotFoundException;
import site.liuming.truismcms.vo.PageConditionVo;
import site.liuming.truismcms.web.mapper.BlogMapper;
import site.liuming.truismcms.web.mapper.BlogtagMapper;
import site.liuming.truismcms.web.mapper.TagMapper;
import site.liuming.truismcms.web.pojo.Blog;
import site.liuming.truismcms.web.pojo.Tag;

import java.util.*;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogtagMapper blogtagMapper;

    /**
     * 查询已发布的博客
     * @param pcv
     * @return
     */
    public UnifyResponse<PagePojoDto<Blog>> getBlogList(PageConditionVo<BlogBo> pcv) {
        PagePojoDto<Blog> result = new PagePojoDto<>();
        PageHelper.startPage(pcv.getPageNum(), pcv.getPageSize());
        BlogBo conditionBlog = pcv.getParamMap();
        Long count = blogMapper.count();
        List<Blog> blogList = blogMapper.selectBlogList(conditionBlog);
        Iterator<Blog> iterator = blogList.iterator();
        while (iterator.hasNext()) {
            Blog blog =iterator.next();
            List<Tag> tagList = tagMapper.selectTagByBlogId(blog.getId());
            blog.setTagList(tagList);
            List<Long> tagsId = pcv.getParamMap().getTagsId();
            if(tagsId.size() != 0 && !containsSubArray(tagList, tagsId)) {
                iterator.remove();
                continue;
            }
        }
        result.setTotal(count);
        result.setPageNum(pcv.getPageNum());
        result.setPageSize(pcv.getPageSize());
        result.setData(blogList);
        return UnifyResponseFactory.success(result);
    }

    /**
     * 根据id查询blog
     * @param id
     * @return
     */
    public UnifyResponse<Blog> getBlogById(Long id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if(blog != null) {
            return UnifyResponseFactory.success(blog);
        }
        throw new NotFoundException(8001);
    }

    /**
     * 更新blog
     * @param blog
     * @return
     */
    @Transactional
    public UnifyResponse<String> updateById(Blog blog) {
        return blogMapper.updateByPrimaryKey(blog) > 0 ? UnifyResponseFactory.success("更新成功" ) : UnifyResponseFactory.fail("更新失败");
    }

    /**
     * 删除blog
     * @param id
     * @return
     */
    @Transactional
    public UnifyResponse<String> deleteBlog(Long id) {
        blogtagMapper.deleteAboutTag(id);
        return blogMapper.deleteByPrimaryKey(id) > 0 ? UnifyResponseFactory.success("删除成功" ) : UnifyResponseFactory.fail("删除失败");
    }


    /**
     * 新增blog
     * @param blogBo
     * @return
     */
    @Transactional
    public UnifyResponse<String> addBlog(BlogBo blogBo) {
        Blog blog = new Blog();
        String title = blogBo.getTitle();
        Long typeId = blogBo.getTypeId();
        List<Long> tagsId = blogBo.getTagsId();
        if(!Objects.nonNull(title)) {
            return UnifyResponseFactory.fail("标题不可为空");
        }
        if(!Objects.nonNull(typeId)) {
            return UnifyResponseFactory.fail("分类不可为空");
        }
        if(!Objects.nonNull(tagsId)) {
            return UnifyResponseFactory.fail("最少需要选择一个标签");
        }
        blog.setTitle(title);
        blog.setTypeId(typeId);
        blog.setUpdateTime(Calendar.getInstance().getTime());
        blog.setPublishTime(Calendar.getInstance().getTime());
        blog.setDraft(blogBo.getDraft() == null ? false : true);
        blog.setSource(blogBo.getSource());
        blog.setContent(blogBo.getContent());
        blog.setViews(0L);
        blog.setLike(0L);
        blog.setCommentCount(0);
        Long count = blogMapper.insertSelective(blog);
        if(!Objects.nonNull(count) || count == 0) {
            return UnifyResponseFactory.fail("新增失败");
        }
        Long blogId= blog.getId();
        Integer counts = blogtagMapper.addCombination(blogId, tagsId);
        if(counts <= 0) {
            return UnifyResponseFactory.fail("新增失败");
        }
        return UnifyResponseFactory.success("新增成功");
    }

    /**
     * 判断标签列表是否包含子标签数组
     * @return
     */
    private boolean containsSubArray(List<Tag> tagList, List<Long> tagsId) {
        HashSet<Long> set = new HashSet<>(tagList.size());
        for (int i = 0; i < tagList.size(); i++) {
            set.add(tagList.get(i).getId());
        }
        for (int i=0; i< tagsId.size(); i++) {
            if(set.add(tagsId.get(i))) {
                return false;
            }
        }
        return true;
    }
}
