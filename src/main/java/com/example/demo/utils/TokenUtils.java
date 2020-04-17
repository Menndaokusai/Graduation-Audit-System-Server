package com.example.demo.utils;


import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

public class TokenUtils {

    /**
     * 创建秘钥
     */
    private static final byte[] SECRET = "6MNSobBRCHGIO0fS6MNSobBRCHGIO0fS".getBytes();

    /**
     * 过期时间360000秒
     */
    private static final long EXPIRE_TIME = 1000 * 360000;


    /**
     * 生成Token
     * @param account
     * @return
     */
    public static String buildJWT(String account) {
        try {
            /**
             * 1.创建一个32-byte的密匙
             */
            MACSigner macSigner = new MACSigner(SECRET);
            /**
             * 2. 建立payload 载体
             */
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("doi")                                                    //主题
                    .issuer("")                                                        //发布者的url地址
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))//该jwt销毁的时间；unix时间戳
                    .claim("account",account)
                    .build();

            /**
             * 3. 建立签名
             */
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);//签名算法以及密匙
            signedJWT.sign(macSigner);

            /**
             * 4. 生成token
             */
            String token = signedJWT.serialize();
            return token;
        } catch (KeyLengthException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static String vaildToken(String token ) {

        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            //校验是否有效
            if (!jwt.verify(verifier)) {
                System.out.println("Token 无效");
                return "401";
            }

            //校验超时
            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (new Date().after(expirationTime)) {
                System.out.println("Token 已过期");
                return "402";
            }

            //获取载体中的数据
            Object account = jwt.getJWTClaimsSet().getClaim("account");
            //是否有openUid
            if (Objects.isNull(account)){
                System.out.println("账号为空");
                return "403";
            }
            return account.toString();
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }


}
