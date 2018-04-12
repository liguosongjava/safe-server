package com.safe.info.core.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 参数加密工具
 */
public class EncryptUtil {
    private static String sKey="I9[/eu2S..cd00pp";
    private static String ivParameter="!Wp;h23f()*lna1[";
    private static EncryptUtil instance=null;
    private static final String encode = "UTF-8";

    private EncryptUtil() {
    }

    // 加密(key,向量均为16位)
    public static String encrypt(String sSrc){
        try {
            Cipher  cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = sKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            //使用CBC模式，需要一个向量iv，可增加加密算法的强度
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(encode));
            return (new BASE64Encoder()).encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 解密(key,向量均为16位)
    public static String decrypt(String sSrc){
        try {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = (new BASE64Decoder()).decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,encode);
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
}
