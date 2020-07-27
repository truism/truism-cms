package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.web.pojo.Tag;
import site.liuming.truismcms.web.service.TagService;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/tag")
@Api(value = "标签管理", tags = {"标签管理"})
@Validated
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "标签列表")
    @GetMapping("/{pageNum}/{pageSize}")
    public PagePojoDto<Tag> getTagList(
            @PathVariable("pageNum") @Min(value = 0) Integer pageNum,
            @PathVariable("pageSize") @Min(value = 0) Integer pageSize,
            String tagName) {

        return tagService.getTagList(pageNum, pageSize, tagName);

    }

    @GetMapping("/{id}")
    public UnifyResponse<Tag> getTagById(@PathVariable("id") Long tagId) {
        return tagService.getTagById(tagId);
    }

    @PostMapping("/")
    public UnifyResponse<String> addTag(@RequestBody Tag tag) {
        return tagService.addTag(tag);
    }

    @PutMapping("/")
    public UnifyResponse<String> updateTag(@RequestBody Tag tag) {
        return  tagService.updateTag(tag);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteTag(@PathVariable("id") Long tagId) {
        return tagService.deleteTagById(tagId);
    }

}
