package com.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.Scope;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/27 22:52
 */

@Component("userService") //当扫描到这个类的时候，要对这个类做一些解析
@Scope("prototype")
public class UserService {
    @Autowired
    public OrderService orderService;

    public void test(){
        System.out.println("\r\n"+orderService);
    }
}
