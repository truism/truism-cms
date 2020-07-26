package site.liuming.truismcms.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.exceptions.HttpException;
import site.liuming.truismcms.mapper.MenuMapper;
import site.liuming.truismcms.sys.pojo.Menu;
import site.liuming.truismcms.sys.pojo.MenuExample;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public UnifyResponse<List<Menu>> getMenus() {
        List<Menu> menus =  menuMapper.selectAll();
        if(menus != null) {
            return UnifyResponseFactory.success(menus);
        }
        throw new HttpException();
    }

}
