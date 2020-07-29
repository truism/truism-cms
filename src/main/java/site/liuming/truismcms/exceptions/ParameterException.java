package site.liuming.truismcms.exceptions;

public class ParameterException extends HttpException {
    public ParameterException(Integer code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
