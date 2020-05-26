package com.coderandyli.encryption.jwt;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/22 下午1:47
 */

import com.google.gson.Gson;
        import io.jsonwebtoken.Claims;
        import io.jsonwebtoken.JwtBuilder;
        import io.jsonwebtoken.Jwts;
        import io.jsonwebtoken.SignatureAlgorithm;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Map;

/**
 * @describe:JWT
 *  使用场景:一种情况是webapi,另一种情况是多web服务器下实现无状态分布式身份验证。 JWT是JSON Web Token的缩写，即JSON Web令牌。JSON Web令牌（JWT）是一种紧凑的、URL安全的方式， 用来表示要在双方之间传递的“声明”。JWT中的声明被编码为JSON对象，用作JSON Web签名（JWS）结构的有效内容或JSON Web加密（JWE）结构的明文，使得声明能够被：数字签名、 或利用消息认证码（MAC）保护完整性、加密。
 * @author:houkai
 * @Date: 2018/3/26 16:49
 */
public class JWTUtils2 {

    /**
     * 解密
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(base64Security.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     * @param map
     * @param base64Security
     * @return
     */
    public static String createJWT(Map<String, Object> map, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(new Gson().toJson(map))
                .signWith(signatureAlgorithm,base64Security.getBytes()); //估计是第三段密钥
        //生成JWT
        return builder.compact();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("province", "898765");
        map.put("city", "898765");
        map.put("appkey", "HMu1H/cmyKDOiHv41Y9lLROuOlOo+PPG8F4/RotRmNc=");
        map.put("timestamp", new Date().getTime());

        //密钥
        String keyt = "79e7c69681b8270162386e6daa53d1dc";
        String token=JWTUtils2.createJWT(map, keyt);
        System.out.println("JWT加密的结果："+ token);
        System.out.println("JWT解密的结果："+ parseJWT(token, keyt));
    }
}
