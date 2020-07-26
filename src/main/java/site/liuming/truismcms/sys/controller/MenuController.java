package site.liuming.truismcms.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.sys.pojo.Menu;
import site.liuming.truismcms.sys.service.MenuService;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public UnifyResponse<List<Menu>> getMenus() {
        return menuService.getMenus();
    }

}
