package site.liuming.truismcms.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.exceptions.HttpException;
import site.liuming.truismcms.exceptions.NotFoundException;

@RestController
public class ExcepController {

  @RequestMapping("/hello")
  public UnifyResponse<String> hello() {
    throw new NotFoundException(2000);
  }

}
