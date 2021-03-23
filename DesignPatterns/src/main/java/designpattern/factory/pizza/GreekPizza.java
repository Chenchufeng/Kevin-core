package designpattern.factory.pizza;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/20 12:13
 */
public class GreekPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("制作希腊披萨，准备原材料");
    }
}
