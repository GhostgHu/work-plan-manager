package com.shimengjie.wpm.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptionUtil {

    /**
     * SHA-1 加密
     */
    public static String sha1(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] messageDigest = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            String shaHex = Integer.toHexString(b & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }

    /**
     *  DES加密
     */
    public static byte[] DESEncrypt(String content, String key) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密
     */
    public static byte[] DESDecrypt(byte[] content, String key) {

        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密后按UTF8组成字符串
     */
    public static String DESDecryptUTF8(byte[] content, String password) {
        byte[] bs = DESDecrypt(content, password);
        try {
            return new String(bs, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String DES2HexEncode(String content, String key) {
        return byteSplit2Hex(DESEncrypt(content, key));
    }

    public static String DES2HexDecode(String hex, String key) {
        return DESDecryptUTF8(hexImplode2OriginBytes(hex), key);
    }

    public static String byteSplit2Hex(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        int len = bytes.length;
        byte b, b1, b2;
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            b = aByte;
            b1 = (byte) ((b >> 4) & 0x0f);
            b2 = (byte) (b & 0x0f);
            sb.append(byteToHex(b1));
            sb.append(byteToHex(b2));
        }
        return sb.toString();
    }


    public static char byteToHex(byte b) {
        if (b >= 0 && b <= 9) {
            return (char) ('0' + b);
        }
        if (b >= 10 && b <= 15) {
            return (char) ('a' + b - 10);
        }
        return '_';
    }

    public static byte hexToByte(char c) {
        if (c >= '0' && c <= '9') {
            return (byte) (c - '0');
        }
        if (c >= 'a' && c <= 'f') {
            return (byte) (c - 'a' + 10);
        }
        throw new IllegalArgumentException("hexToByte char:" + c);
    }

    public static byte[] hexImplode2OriginBytes(String hex) {
        int len = hex.length();
        if (len % 2 != 0) {
            return hex.getBytes();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for (int i = 0; i < len; ) {
            byte b1 = hexToByte(hex.charAt(i));
            byte b2 = hexToByte(hex.charAt(i + 1));
            bos.write((b1 << 4) | (b2 & 0x0f));
            i += 2;
        }
        return bos.toByteArray();
    }

    public static String md5(String str) {
        String encodeStr = null;
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            encodeStr = byteSplit2Hex(digest);
        } catch (NoSuchAlgorithmException e) {
        }
        return encodeStr;
    }
}