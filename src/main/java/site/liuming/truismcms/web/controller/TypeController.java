package site.liuming.truismcms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.web.pojo.Type;
import site.liuming.truismcms.web.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/list/{name}")
    public UnifyResponse<List<Type>> getTypeList(@PathVariable String name) {
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
