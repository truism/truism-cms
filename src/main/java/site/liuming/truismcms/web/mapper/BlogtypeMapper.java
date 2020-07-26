package site.liuming.truismcms.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.liuming.truismcms.web.pojo.Blogtype;
import site.liuming.truismcms.web.pojo.BlogtypeExample;

public interface BlogtypeMapper {
    long countByExample(BlogtypeExample example);

    int deleteByExample(BlogtypeExample example);

    int insert(Blogtype record);

    int insertSelective(Blogtype record);

    List<Blogtype> selectByExample(BlogtypeExample example);

    int updateByExampleSelective(@Param("record") Blogtype record, @Param("example") BlogtypeExample example);

    int updateByExample(@Param("record") Blogtype record, @Param("example") BlogtypeExample example);
}