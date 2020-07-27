package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.web.pojo.Tag;
import site.liuming.truismcms.web.service.TagService;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/tag")
@Api(value = "标签管理", tags = {"标签管理"})
@Validated
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/list")
    public UnifyResponse<List<Tag>> getAllTag() {
        return tagService.getAllTag();
    }

    @GetMapping("/name/{tagName}")
    public UnifyResponse<List<Tag>> getTagByName(@PathVariable String tagName) {
        return tagService.getTagByName(tagName);
    }

    @ApiOperation(value = "标签列表")
    @GetMapping("/{pageNum}/{pageSize}")
    public UnifyResponse<PagePojoDto<Tag>> getTagList(
            @PathVariable("pageNum") @Min(value = 0) Integer pageNum,
            @PathVariable("pageSize") @Min(value = 0) Integer pageSize) {

        PagePojoDto<Tag> pagePojoDto = tagService.getTagList(pageNum, pageSize);
        return UnifyResponseFactory.success(pagePojoDto);
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
