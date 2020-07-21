package site.liuming.truismcms.core.common;

/**
 * The class UnifyResponse.
 *
 * @param <T>
 */
public class UnifyResponse<T> {

  private int code;

  private boolean flag;

  private String message;

  private T data;

  public UnifyResponse(int code, boolean flag, String message) {
    this.code = code;
    this.flag = flag;
    this.message = message;
  }

  public UnifyResponse(int code, boolean flag, String message, T data) {
    this.code = code;
    this.flag = flag;
    this.message = message;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "UnifyResponse{"
        + "code="
        + code
        + ", flag="
        + flag
        + ", message='"
        + message
        + '\''
        + ", data="
        + data
        + '}';
  }
}
