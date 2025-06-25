package test;

import io.jsonwebtoken.io.Encoders;
import util.JwtHelper;
import org.testng.annotations.Test;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import io.jsonwebtoken.*;

public class TestJwtHelper {

    @Test
    public void testAllMethod() throws InterruptedException {
        String token = JwtHelper.createToken(1L);
        System.out.println(token);

        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);
        System.out.println(JwtHelper.isExpiration(token));

        Thread.sleep(6000);
        System.out.println(JwtHelper.isExpiration(token));
    }

    public static void main(String[] args) {
        // 生成安全的HS256密钥（256位）
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // 将密钥保存为Base64字符串（便于存储和传输）
        String secretKeyBase64 = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println("生成的安全密钥(Base64): " + secretKeyBase64);
    }

}
