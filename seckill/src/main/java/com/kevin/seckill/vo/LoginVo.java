package com.kevin.seckill.vo;

import com.kevin.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: chufeng Chen
 * @Description:登录参数
 * @Date:Create：in 2021/6/27 15:03
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile(required = true)
    private String mobile;

    @NotNull
    @Length(min=32)
    private String password;
}
