package com.kevin.seckill.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: chufeng Chen
 * @Description:手机号码校验
 * @Date:Create：in 2021/6/27 15:38
 */
public class ValidatorUtil {
    private static Pattern MOBILE_PATTERN = Pattern.compile("[1]([3-9])[0-9]{9}$");

    /*/**
     * @Author Chufeng
     * @Description 手机号码校验
     * @Date 15:44 2021/6/27
     * @Param [mobile]
     * @return boolean
     */
    public static boolean isMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        Matcher matcher=MOBILE_PATTERN.matcher(mobile);
        return matcher.matches();
    }
}
