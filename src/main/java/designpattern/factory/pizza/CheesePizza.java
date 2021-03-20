package designpattern.factory.pizza;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/20 12:12
 */
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("制作奶酪披萨，准备原材料");
    }
}
