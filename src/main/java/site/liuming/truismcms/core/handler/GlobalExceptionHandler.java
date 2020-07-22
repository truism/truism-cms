package site.liuming.truismcms.core.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public UnifyResponse<String> handleServerException() {
    return UnifyResponseFactory.fail("服务器异常，请稍后重试!");
  }




}
