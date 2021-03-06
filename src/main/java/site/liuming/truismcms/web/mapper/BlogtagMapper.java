package site.liuming.truismcms.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import site.liuming.truismcms.web.pojo.Blogtag;
import site.liuming.truismcms.web.pojo.BlogtagExample;
import site.liuming.truismcms.web.pojo.Tag;

@Repository
public interface BlogtagMapper {
    long countByExample(BlogtagExample example);

    int deleteByExample(BlogtagExample example);

    int insert(Blogtag record);

    int insertSelective(Blogtag record);

    List<Blogtag> selectByExample(BlogtagExample example);

    int updateByExampleSelective(@Param("record") Blogtag record, @Param("example") BlogtagExample example);

    int updateByExample(@Param("record") Blogtag record, @Param("example") BlogtagExample example);

    List<Tag> selectBlogTags(@Param("id") Long id);

    int deleteAboutTag(@Param("id") Long id);

    Integer addCombination(@Param("blogId") Long blogId, @Param("tagsId") List<Long> tagsId);

    List<Long> selectTagsid(@Param("id") Long id);

    Long countBlogs(@Param("id") Long tagId);
}