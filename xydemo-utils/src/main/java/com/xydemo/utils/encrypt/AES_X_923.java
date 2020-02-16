package com.xydemo.utils.encrypt;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;

public class AES_X_923 {

    //==========================AES 加密================================================
    public static final String ALGORITHM = "AES"; //AES/CBC/NoPadding
    public static final String AESMODE   = "AES/CBC/NoPadding"; //AES/CBC/NoPadding

    /**
     * aes encrypt
     * @param encryptKey
     * @param encryptIv
     * @param encryptStr
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String encryptX923(String encryptKey,  String encryptIv, String encryptStr,AesEncoding encoding) throws Exception {
        byte[] encBytes = descryptX923(encryptKey.getBytes(),encryptIv.getBytes(),encryptStr.getBytes());
        String encryptBytes = null;
        if (encoding.name().equals(AesEncoding.hex.name())) {
            encryptBytes = Base64Util.encodeByte(encBytes);
        } else {//hex
            encryptBytes = BytesUtility.bytesToHexString(encBytes);
        }
        return encryptBytes;
    }



    /**
     * aes descryptX923
     * @param encryptKey
     * @param encryptIv
     * @param descryptStr
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String descryptX923(String encryptKey,  String encryptIv, String descryptStr,AesEncoding encoding) throws Exception {
        byte[] descryptBytes = null;
        if (encoding.name().equals(AesEncoding.hex.name())) {
            descryptBytes = Base64Util.decode(descryptStr);
        } else {//hex
            descryptBytes = BytesUtility.hexStringToBytes(descryptStr);
        }

        byte[] descBytes = descryptX923(encryptKey.getBytes(),encryptIv.getBytes(),descryptBytes);
        String descrypt = new String(descBytes,"UTF-8");
        return descrypt;
    }



    /**
     * 加密AES ANSI X.923
     * @param encryptKey
     * @param encryptIv
     * @param encryptStr
     * @return
     * @throws Exception
     */
    public static byte[] encryptX923( byte[] encryptKey,  byte[] encryptIv, String encryptStr) throws Exception {
        if (StringUtils.isEmpty(encryptStr)) {
            return null;
        }
        byte[] fillb = new byte[0];
        if (encryptStr.length() > 0 && encryptStr.length() % 16 != 0) {
            int len = 16 - encryptStr.length() % 16;
            fillb = new byte[len];
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    fillb[i] = (byte) len;
                } else {
                    fillb[i] = 0x00;
                }
            }
        }
        Cipher cipher = Cipher.getInstance(AESMODE);
        IvParameterSpec ivspec = new IvParameterSpec(encryptIv);
        SecretKeySpec keyspec = new SecretKeySpec(encryptKey, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encryptStrBytes = encryptStr.getBytes("UTF-8");
        byte[] byteMerger = BytesUtility.combineByteArray(encryptStrBytes, fillb);

        byte[] aesByte = cipher.doFinal(byteMerger);
        return aesByte;
    }


    /**
     * 16进制aes解密  ANSI X.923
     * @param encryptKey
     * @param encryptIv
     * @param descrypt
     * @return
     * @throws Exception
     */
    public static byte[] descryptX923(byte[] encryptKey, byte[] encryptIv, byte[] descrypt) throws Exception {
        IvParameterSpec ivspec = new IvParameterSpec(encryptIv);
        Cipher cipher = Cipher.getInstance(AESMODE);
        SecretKeySpec keyspec = new SecretKeySpec(encryptKey, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
        byte[] decryptBytes = cipher.doFinal(descrypt);

        int len = decryptBytes.length;
        int lastB = (int)decryptBytes[len - 1];

        int realLen = len - lastB;
        byte[] bt3 = new byte[realLen];
        System.arraycopy(decryptBytes,0,bt3,0,realLen);
        return bt3;
    }


    /**
     * 生成密钥
     *
     * @return
     * @throws Exception
     */
    private static SecretKey geneKey(String key) throws Exception {
        //获取一个密钥生成器实例
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = new SecureRandom();
        random.setSeed(key.getBytes());//设置加密用的种子，密钥
        keyGenerator.init(random);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }


    /**
     * 读取存储的密钥
     *
     * @param keyPath
     * @return
     * @throws Exception
     */
    private SecretKey readKey(Path keyPath) throws Exception {
        //读取存起来的密钥
        byte[] keyBytes = Files.readAllBytes(keyPath);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        return keySpec;
    }




}
