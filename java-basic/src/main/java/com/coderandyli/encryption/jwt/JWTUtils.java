//package com.coderandyli.encryption.jwt;
//
//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
//import io.jsonwebtoken.*;
//import org.apache.tomcat.util.codec.binary.Base64;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.SignatureException;
//import java.util.Date;
//
///**
// * @author lizhenzhen
// * @version 1.0
// * @date 2020/5/22 下午1:44
// */
//public class JWTUtils {
//
//    static String SECRETKEY = "KJHUhjjJYgYUllVbXhKDHXhkSyHjlNiVkYzWTBac1Yxkjhuad";
//
//    /**
//     * 由字符串生成加密key
//     *
//     * @return
//     */
//    public static SecretKey generalKey(String stringKey) {
//        byte[] encodedKey = Base64.decodeBase64(stringKey);
//        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//        return key;
//    }
//
//    /**
//     * 创建jwt
//     * @param id 唯一id，uuid即可
//     * @param subject json形式字符串或字符串，增加用户非敏感信息存储，如用户id或用户账号，与token解析后进行对比，防止乱用
//     * @param expirationDate  生成jwt的有效期，单位秒
//     * @return jwt token
//     * @throws Exception
//     */
//    public static String createJWT(String userName, String subject, long expirationDate) throws Exception {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//        SecretKey key = generalKey(SECRETKEY);
//        JwtBuilder builder = Jwts.builder().setIssuer("").setId(userName).setIssuedAt(now).setSubject(subject)
//                .signWith(signatureAlgorithm, key);
//        if (expirationDate >= 0) {
//            long expMillis = nowMillis + expirationDate*1000;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//        return builder.compact();
//    }
//
//    /**
//     * 解密jwt，获取实体
//     * @param jwt
//     */
//    public static Claims parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException,
//            MalformedJwtException, SignatureException, IllegalArgumentException {
//        SecretKey key = generalKey(SECRETKEY);
//        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
//        return claims;
//    }
//
//}
