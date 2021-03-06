package com.kevin.seckill.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Title: CookieUtil
 * Description:·Cookie工具类
 * @author Chufeng Chen
 */
public final class CookieUtil {

    private static String LOCALHOST = "localhost";
    private static String HTTP = "http://";
    private static String SEPARATOR_1= ":";
    private static String SEPARATOR_2 = "/";
    private static int ADDRESS_LENGTH = 3;

    /**
     * 得到Cookie的值，不编码
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 得到Cookie的值
     *
     * @param request
     * @param cookieName
     * @param isDecoder
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 设置Cookie的值不设置生效时间默认浏览器关闭即失效，也不编码
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值在指定时间内生效，但不编码
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值不设生效时间，但编码
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param isEncode
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

    /**
     * 设置Cookie的值在指定时间内生效，编码参数
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param isEncode
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值在指定时间内生效，编码参数（指定编码）
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param encodeString
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 刷除Cookiecookie域名
     *
     * @param request
     * @param response
     * @param cookieName
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param isEncode
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean
                                                  isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {
                //设置域名的cookie
                String domainName = getDomainName(request);
                if (!LOCALHOST.equals(domainName)) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath(SEPARATOR_2);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage Cookie生效的最大秒数
     * @param encodeString
     */
    public static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                         String cookieName, String cookieValue, int cookieMaxage, String
                                                 encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {
                //设置城名的cookie
                String domainName = getDomainName(request);
                if (!LOCALHOST.equals(domainName)) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath(SEPARATOR_2);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到cookie的域名
     *
     * @param request
     * @return
     */
    public static final String getDomainName(HttpServletRequest request) {
        String domainName = null;
        // 通过request对象获取访问的url地址
        String serverName = request.getRequestURL().toString();
        if (serverName == null || "".equals(serverName)) {
            domainName = "";
        } else {
            // 将url地址转换为小写
            serverName = serverName.toLowerCase();
            // 如果url地址是以http://开头 将http://裁取
            if (serverName.startsWith(HTTP)) {
                serverName = serverName.substring(7);
            }
            int end = serverName.length();
            // 判断url地址是否包含"/"
            if (serverName.contains(SEPARATOR_2)) {
                //得到第一个"/“出现的位置
                end = serverName.indexOf(SEPARATOR_2);
            }

            //截取
            serverName = serverName.substring(0, end);
            //根据”，“进行分割
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > ADDRESS_LENGTH) {
                // www.XXx.com.cn
                domainName = domains[len-4] + "." +domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= ADDRESS_LENGTH && len > 1) {
                // xxx.com or xxx.cn
                domainName = domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(SEPARATOR_1) > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }
}