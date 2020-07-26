package site.liuming.truismcms.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("site.liuming.truismcms.web.mapper")
public class MybatisConfig {


}
