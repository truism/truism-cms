package site.liuming.truismcms.exceptions;

public class HttpException extends RuntimeException {

  protected int code = 500;

  protected int httpStatusCode;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(int httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }
}
