package site.liuming.truismcms.exceptions;

public class ForbiddenUpdateException extends HttpException {
    public ForbiddenUpdateException(Integer code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
