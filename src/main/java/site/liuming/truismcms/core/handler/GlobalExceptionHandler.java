package site.liuming.truismcms.core.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.core.config.ExceptionMessageConfig;
import site.liuming.truismcms.exceptions.HttpException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @Autowired
  private ExceptionMessageConfig messageConfig;

  /**
   * 处理服务器异常
   * @param request
   * @param e
   * @return
   */
  @ResponseBody
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public UnifyResponse<String> handleServerException(HttpServletRequest request, Exception e) {

    String requestUrl = request.getRequestURI();
    String method = request.getMethod();

    return UnifyResponseFactory.fail("访问" + method + ":" + requestUrl + "服务器异常，请稍后重试!");
  }

  /**
   * 处理客户端 Http 异常
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(HttpException.class)
  public ResponseEntity<UnifyResponse<String>> handleHttpException(HttpServletRequest request, HttpException e) {
    String requestUrl = request.getRequestURI();
    String method = request.getMethod();

    Integer httpStatusCode = e.getHttpStatusCode();
    Integer code = e.getCode();
    String message = messageConfig.getMessage(code);
    UnifyResponse<String> unifyResponse = UnifyResponseFactory.fail(code,method + " " + requestUrl +" " + message);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

    HttpStatus httpStatus = HttpStatus.resolve(httpStatusCode);
    ResponseEntity<UnifyResponse<String>> entity = new ResponseEntity<>(unifyResponse, headers, httpStatus);

    return entity;
  }


}
