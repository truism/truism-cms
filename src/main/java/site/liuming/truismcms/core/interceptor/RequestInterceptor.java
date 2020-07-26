package site.liuming.truismcms.core.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import site.liuming.truismcms.exceptions.AuthorizationException;
import site.liuming.truismcms.utils.JwtToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final String LOGIN_URI = "/user/login";

    private static final String SWAGGER_API = "/swagger-ui.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestUri = request.getRequestURI();
//        if(LOGIN_URI.equalsIgnoreCase(requestUri) || SWAGGER_API.equalsIgnoreCase(requestUri)) {
//            return true;
//        }
//        String token = request.getHeader("Authorization");
//        if(token == null) {
//            throw new AuthorizationException(3001);
//        }
//        final boolean result = JwtToken.verifyToken(token);
        return true;
    }
}
