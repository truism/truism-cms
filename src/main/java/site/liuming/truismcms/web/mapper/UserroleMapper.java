package site.liuming.truismcms.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.liuming.truismcms.web.pojo.Userrole;
import site.liuming.truismcms.web.pojo.UserroleExample;

public interface UserroleMapper {
    long countByExample(UserroleExample example);

    int deleteByExample(UserroleExample example);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    List<Userrole> selectByExample(UserroleExample example);

    int updateByExampleSelective(@Param("record") Userrole record, @Param("example") UserroleExample example);

    int updateByExample(@Param("record") Userrole record, @Param("example") UserroleExample example);
}