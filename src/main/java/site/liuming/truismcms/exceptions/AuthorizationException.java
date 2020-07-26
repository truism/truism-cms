package site.liuming.truismcms.exceptions;

public class AuthorizationException extends HttpException {

    public AuthorizationException(Integer code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
