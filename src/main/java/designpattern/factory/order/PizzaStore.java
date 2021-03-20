package designpattern.factory.order;

import designpattern.factory.SimplyFactory;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/20 12:25
 */
//相当于一个客户端，发出Pizza订购任务
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimplyFactory());
    }
}
