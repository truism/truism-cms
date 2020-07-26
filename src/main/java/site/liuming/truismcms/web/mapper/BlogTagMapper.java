package site.liuming.truismcms.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.liuming.truismcms.web.pojo.BlogTag;
import site.liuming.truismcms.web.pojo.BlogTagExample;

public interface BlogTagMapper {
    long countByExample(BlogTagExample example);

    int deleteByExample(BlogTagExample example);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    List<BlogTag> selectByExample(BlogTagExample example);

    int updateByExampleSelective(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByExample(@Param("record") BlogTag record, @Param("example") BlogTagExample example);
}