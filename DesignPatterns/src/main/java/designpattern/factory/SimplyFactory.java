package designpattern.factory;

import designpattern.factory.pizza.CheesePizza;
import designpattern.factory.pizza.GreekPizza;
import designpattern.factory.pizza.Pizza;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/20 14:36
 */
//根据orderType返回对应的pizza对象
public class SimplyFactory {
    public Pizza createPizza(String orderType){
        Pizza pizza=null;
        System.out.println("使用简单工厂模式");
            if (orderType.equals("Greek")){
                pizza=new GreekPizza();
                pizza.setName("希腊披萨");
            }else if(orderType.equals("Cheese")){
                pizza=new CheesePizza();
                pizza.setName("奶酪披萨");

            }
            return pizza;
    }
}
