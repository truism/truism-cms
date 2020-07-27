package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.bo.BlogBo;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.vo.PageConditionVo;
import site.liuming.truismcms.web.pojo.Blog;
import site.liuming.truismcms.web.service.BlogService;


@RestController
@RequestMapping("/blog")
@Api(value = "博客管理", tags = {"博客管理"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/list")
    public UnifyResponse<PagePojoDto<Blog>> getBlogList(@RequestBody PageConditionVo<BlogBo> pcv) {
        return blogService.getBlogList(pcv);
    }

    @PostMapping("/")
    public UnifyResponse<String> addBlog(@RequestBody Blog blog){
        return blogService.addBlog(blog);
    }

    @PutMapping("/")
    public UnifyResponse<String> updateBlog(@RequestBody Blog blog) {
        return blogService.updateById(blog);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteBlog(@PathVariable("id") Long id) {
        return blogService.deleteBlog(id);
    }

    @GetMapping("/{id}")
    public UnifyResponse<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

}
