package util;

import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtHelper {
    private static final long tokenExpiration = 1000 * 60 * 60;
    private static final String tokenSignKey = "uhJP1vdK3OG+sd9tVTqkijhtMvAAMwcQogfyJo13wJs=";

    // generate token string
    public static String createToken(Long userId) {
        // return token
        return Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS256, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    // get userid through token
    public static Long getUserId(String token) {
        if(StringUtils.isEmpty(token))
            return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer)claims.get("userId");
        return userId.longValue();
    }

    // judge if token is effective
    public static boolean isExpiration(String token){
        try {
            // return is Expiration or not
            return Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration().before(new Date());
        } catch(Exception e) {
            // out of time, return true
            return true;
        }
    }
}
