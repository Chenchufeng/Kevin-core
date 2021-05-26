package com.kevin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/5/26 21:55
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private int age;
}
