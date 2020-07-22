package site.liuming.truismcms.exceptions;

public class HttpException extends RuntimeException {

  private int code;

  private int httpStatusCode;

  private String message;

}
