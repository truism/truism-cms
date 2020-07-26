package site.liuming.truismcms.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.liuming.truismcms.web.pojo.BlogType;
import site.liuming.truismcms.web.pojo.BlogTypeExample;

public interface BlogTypeMapper {
    long countByExample(BlogTypeExample example);

    int deleteByExample(BlogTypeExample example);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    List<BlogType> selectByExample(BlogTypeExample example);

    int updateByExampleSelective(@Param("record") BlogType record, @Param("example") BlogTypeExample example);

    int updateByExample(@Param("record") BlogType record, @Param("example") BlogTypeExample example);
}