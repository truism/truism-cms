package site.liuming.truismcms.exceptions;

public class BadOperateException extends HttpException {
    public BadOperateException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
