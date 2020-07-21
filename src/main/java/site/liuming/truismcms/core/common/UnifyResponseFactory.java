package site.liuming.truismcms.core.common;

/** The UnifyResponse factory class. */
public class UnifyResponseFactory {

  public static <T> UnifyResponse<T> success(T data) {
    return new UnifyResponse<>(2000, true, "操作成功", data);
  }

  public static <T> UnifyResponse<T> success(String message) {
    return new UnifyResponse<>(2000, true, message);
  }

  public static <T> UnifyResponse<T> success(int code, String message) {
    return new UnifyResponse<>(code, true, message);
  }

  public static <T> UnifyResponse<T> success(int code, String message, T data) {
    return new UnifyResponse<>(code, true, message, data);
  }

  public static <T> UnifyResponse<T> fail(T data) {
    return new UnifyResponse<>(4000, false, "操作失败", data);
  }

  public static <T> UnifyResponse<T> fail(String message) {
    return new UnifyResponse<>(4000, false, message);
  }

  public static <T> UnifyResponse<T> fail(int code, String message) {
    return new UnifyResponse<>(code, false, message);
  }

  public static <T> UnifyResponse<T> fail(int code, String message, T data) {
    return new UnifyResponse<>(code, false, message, data);
  }
}
