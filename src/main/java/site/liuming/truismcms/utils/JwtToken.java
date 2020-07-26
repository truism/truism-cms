package site.liuming.truismcms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import site.liuming.truismcms.sys.pojo.User;
import site.liuming.truismcms.sys.service.UserService;

import java.util.*;

@Component
public class JwtToken {

    private static String jwtKey;

    private static Integer expiredTimeIn;

    @Value("${truism.cms.security.jwt-key}")
    public void setJwtKey(String jwtKey) {
        JwtToken.jwtKey = jwtKey;
    }

    @Value("${truism.cms.security.expired-in}")
    public void setExpiredTimeIn(Integer expiredTimeIn) {
        JwtToken.expiredTimeIn = expiredTimeIn;
    }

    /**
     * 获取签名
     * @param token
     * @return
     */
    public static Optional<Map<String, Claim>> getClaims(String token) {
        DecodedJWT decodedJWT;
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            decodedJWT = jwtVerifier.verify(token);
        }catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(decodedJWT.getClaims());
    }

    /**
     * 颁发Token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        Map<String,Date> map = calculateExpiredTime();

        return JWT.create()
                .withClaim("uid", user.getId())
                .withExpiresAt(map.get("expiredTime"))
                .withIssuedAt(map.get("mow"))
                .sign(algorithm);
    }

    /**
     * 验证Token
     * @param token
     * @return
     */
    public static Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        }catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

    /**
     * 计算过期时间
     * @return
     */
    private static Map<String, Date> calculateExpiredTime() {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, JwtToken.expiredTimeIn);
        map.put("now", now);
        map.put("expiredTime", calendar.getTime());
        return map;
    }
}
