package TemplateMethodPattern;

/**
 * @Author: Kevin
 * @Date: 2021/8/16 22:48
 * @Description:  具体子类
 */
public class ConcreteClass extends AbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}