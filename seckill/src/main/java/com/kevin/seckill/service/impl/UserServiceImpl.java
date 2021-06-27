package com.kevin.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.seckill.mapper.UserMapper;
import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IUserService;
import com.kevin.seckill.utils.MD5Util;
import com.kevin.seckill.utils.ValidatorUtil;
import com.kevin.seckill.vo.LoginVo;
import com.kevin.seckill.vo.RespBean;
import com.kevin.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2021-06-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /*/**
     * @Author Chufeng
     * @Description 登录
     * @Date 15:17 2021/6/27
     * @Param [loginVo]
     * @return java.lang.String
     */
    @Override
    public RespBean doLogin(LoginVo loginVo) {

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

//        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号码获取用户
        User user = userMapper.selectById(mobile);
        if(null == user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if(!MD5Util.fromPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success();
    }
}
