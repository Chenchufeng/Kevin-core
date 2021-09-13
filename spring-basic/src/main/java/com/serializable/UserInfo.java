package com.serializable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author: Kevin
 * @Date: 2021/8/18 12:45
 * @Description:
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 996890129747019948L;
    private String name;
    private transient String psw;

    public UserInfo(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}