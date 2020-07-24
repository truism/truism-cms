package site.liuming.truismcms;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {

  public static void main(String[] args) throws Exception {
    boolean overwrite = true;
    InputStream is = MybatisGenerator.class.getResourceAsStream("/mybatis-generator.xml");
    List<String> warnings = new ArrayList<>();
    ConfigurationParser parser = new ConfigurationParser(warnings);
    Configuration configuration = parser.parseConfiguration(is);
    is.close();
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warnings);
    generator.generate(null);
    for(String str : warnings) {
      System.out.println(str);
    }
  }
}
