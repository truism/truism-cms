package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.web.pojo.Type;
import site.liuming.truismcms.web.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/type")
@Api(value = "分类管理", tags = {"分类管理"})
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    public UnifyResponse<List<Type>> getAllType() {
        return typeService.getAll();
    }

    @ApiOperation("获取分类列表")
    @ApiImplicitParam(name = "name", value = "分类名称", required = false, dataType = "String")
    @GetMapping("/list")
    public UnifyResponse<List<Type>> getTypeList(@RequestParam(value = "name", required = false) String name) {
        return typeService.getTypeList(name);
    }

    @GetMapping("/{id}")
    public UnifyResponse<Type> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }

    @PostMapping("/")
    public UnifyResponse<String> addType(@RequestBody Type type) {
        return typeService.addType(type);
    }

    @PutMapping("/")
    public UnifyResponse<String> updateType(@RequestBody Type type) {
        return typeService.updateType(type);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteType(@PathVariable Long id) {
        return typeService.deleteType(id);
    }


}
