package com.xydemo.utils.jwt;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: JWT工具类
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/6 15:46
 */
public class JwtUtil {

    public final static String JWT_SECRET   = "c86d9aad02767d980fbbf8fd8c80b357";
    public final static String JWT_ISSUER   = "JWT_DRAGON-Yeah";
    public final static String JWT_USERS    = "JWT_USERS";

    public final static String JWT_USERID    = "userId";
    public final static String JWT_USERNAME  = "userName";
    public final static String JWT_ROLE_LIST  = "roleIdList";

    /**
     * 生成秘钥
     * @return
     */
    private static SecretKey generateKey() {
        byte[] encodedKey = Base64.decodeBase64(JWT_SECRET);
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return secretKey;
    }


    /**
     * 生成token
     *
     * @param authenUser
     * @param timeOutSeconds
     * @return
     */
    public static String generateToken(AuthenUser authenUser, int timeOutSeconds) {
        try {
            // 设置签发算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            // 生成密钥
            SecretKey key = generateKey();
            // 设置私有声明
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put(JWT_USERID, authenUser.getUserId());
            claims.put(JWT_USERNAME, authenUser.getUsername());
            // 记录生成JWT的时间
//            long nowMillis = System.currentTimeMillis();
            // 设置过期时间
            Date now = DateUtil.date();
            Date expireDate = DateUtil.offsetSecond(now, timeOutSeconds);
            // 创建tocken构建器实例
            JwtBuilder jwtBuilder = Jwts.builder()
                    // 设置自己的私有声明
                    .setClaims(claims)
                    // 设置该tocken的Id，用于防止tocken重复
                    .setId(UUID.randomUUID().toString())
                    // 设置签发者
                    .setIssuer(JWT_ISSUER)
                    // 设置签发时间
                    .setIssuedAt(now)
                    // 设置过期时间
                    .setExpiration(expireDate)
                    // 设置tocken的签发对象
                    .setSubject(JWT_USERS)
                    // 设置签发算法和密钥
                    .signWith(signatureAlgorithm, key);
            return jwtBuilder.compact();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解析jwt token
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        SecretKey key = generateKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 授权用户
     * @param token
     * @return
     */
    public static AuthenUser parseToken2AuthenUser(String token){
        AuthenUser authenUser = new AuthenUser();
        try {
            Claims claims = parseToken(token);
            String userId = claims.get(JWT_USERID, String.class);
            String userName = claims.get(JWT_USERNAME, String.class);
            authenUser.setUserId(userId);
            authenUser.setUsername(userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return authenUser;
    }

    /**
     * 检查token
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken){
        JwtUtil.parseToken(jwtToken);
        return true;
    }


    public static void main(String[] args) {
        AuthenUser user = new AuthenUser();
        user.setUserId("xertes235422y345");
        user.setUsername("15626222192");
        String token = generateToken(user, 2);
        System.out.println("token:" + token);

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKV1RfVVNFUlMiLCJpc3MiOiJKV1RfRFJBR09OLVllYWgiLCJ1c2VyTmFtZSI6IjE1NjI2MjIyMTkyIiwiZXhwIjoxNTY1MDgwNzE2LCJ1c2VySWQiOiJ4ZXJ0ZXMyMzU0MjJ5MzQ1IiwiaWF0IjoxNTY1MDgwNzE0LCJqdGkiOiJjOGQ0YjUyZi0zZjM0LTQzMmMtOWNjYy0xZTRkNGJhNGYxMTAifQ.39-iN2EumgJmvtwupu-eQUbPEBeZzoIX_5AMKyGGZ5I";
        Claims claims = parseToken(token);
        String userId = claims.get(JWT_USERID, String.class);
        String userName = claims.get(JWT_USERNAME, String.class);
        System.out.println("userId:" + userId + ",userName:" + userName);
    }

}
