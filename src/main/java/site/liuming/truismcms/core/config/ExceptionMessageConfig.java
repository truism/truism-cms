package site.liuming.truismcms.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource(value="classpath:exception-message/exception-message.properties")
@ConfigurationProperties(prefix = "truism")
public class ExceptionMessageConfig {

  private Map<Integer, String> codes = new HashMap<>();

  public Map<Integer, String> getCodes() {
    return codes;
  }

  public void setCodes(Map<Integer, String> codes) {
    this.codes = codes;
  }

  public String getMessage(Integer code) {
    return codes.get(code);
  }
}
