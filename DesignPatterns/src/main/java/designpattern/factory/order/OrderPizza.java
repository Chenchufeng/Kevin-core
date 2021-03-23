package designpattern.factory.order;

import designpattern.factory.SimplyFactory;
import designpattern.factory.pizza.CheesePizza;
import designpattern.factory.pizza.GreekPizza;
import designpattern.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/20 12:14
 */
public class OrderPizza {
    //定义一个简单工厂对象
    SimplyFactory simplyFactory;
    Pizza pizza=null;

    public OrderPizza(SimplyFactory simplyFactory){
        setSimplyFactory(simplyFactory);
    }


    public void setSimplyFactory(SimplyFactory simplyFactory){
        String orderType="";
        this.simplyFactory=simplyFactory;
        do {
            orderType=getOrderType();
            pizza = this.simplyFactory.createPizza(orderType);
            if (pizza!=null){ //订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购披萨失败~");
                break;
            }
        }while (true);
    }


    //写一个方法，可以获取客户希望订购的Pizza种类
    private String getOrderType() {
        try {
            BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String line = null;
            line = input.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
