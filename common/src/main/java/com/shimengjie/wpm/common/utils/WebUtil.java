package com.shimengjie.wpm.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * web公用工具
 *
 * @author shimengjie
 */
public class WebUtil {

    public static final String SPLITTER = "+";

    /**
     * 生成 CSRF TOKEN
     *
     * @param desKey    加密的密钥
     * @param identity  用户唯一标识
     * @param randomLen 随机长度
     * @return csrf-token
     */
    public static String createCSRFToken(String desKey, String identity, int randomLen) {
        long t = System.currentTimeMillis();
        String token = RandomStringUtils.randomAlphanumeric(randomLen) + SPLITTER + identity + SPLITTER + t;
        return EncryptionUtil.DES2HexEncode(token, desKey);
    }

    /**
     * 从 csrf-token 中解密出要验证的数据
     *
     * @param csrfToken 前端传入的 csrf-token
     * @param desKey    加密的密钥
     * @return 解密后的内容
     */
    public static String getCSRFToken(String csrfToken, String desKey) {
        return EncryptionUtil.DES2HexDecode(csrfToken, desKey);
    }

    /**
     * 返回请求的源IP
     *
     * @param request 请求
     * @return IP地址
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;
        String UN_KNOWN = "unknown";
        // X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || UN_KNOWN.equalsIgnoreCase(ipAddresses)) {
            // X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UN_KNOWN.equalsIgnoreCase(ipAddresses)) {
            // Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UN_KNOWN.equalsIgnoreCase(ipAddresses)) {
            // WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || UN_KNOWN.equalsIgnoreCase(ipAddresses)) {
            // HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }
        // 还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
