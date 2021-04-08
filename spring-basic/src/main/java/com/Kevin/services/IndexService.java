package com.Kevin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/8 21:40
 */
@Component
public class IndexService {

//    @Autowired
//    UserService userService;

    public IndexService() {
        System.out.println("Construct from IndexService");
    }
//    public void getService(){
//        System.out.println(userService);
//    }
}
