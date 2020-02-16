package com.xydemo.utils.encrypt;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * aes 128 cbc pkcs5
 */
public class AES_CBC_PKCS5 {

    // 加密
    public static String encrypt(String enStr, String sKey ,String sVi,AesEncoding encoding) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(sVi.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(enStr.getBytes());

        if(encoding.name().equals(AesEncoding.base64.name())){
            return Base64Util.encodeByte(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }else{//hex
            return BytesUtility.bytesToHexString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }


    }

    // 解密
    public static String decrypt(String deSrc, String sKey ,String sVi,AesEncoding encoding) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(sVi.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] encrypted = null;
            if(encoding.name().equals(AesEncoding.base64.name())){
                encrypted = Base64Util.decode(deSrc);//先用base64解密
            }else{
                encrypted = BytesUtility.hexStringToBytes(deSrc);
            }
            try {
                byte[] original = cipher.doFinal(encrypted);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }



}
