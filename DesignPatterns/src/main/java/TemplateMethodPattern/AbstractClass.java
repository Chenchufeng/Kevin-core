package TemplateMethodPattern;

/**
 * @Author: Kevin
 * @Date: 2021/8/16 22:43
 * @Description: 模板方法设计模式
 */
public abstract class AbstractClass {
    //抽象方法1
    public abstract void abstractMethod1();
    //抽象方法2
    public abstract void abstractMethod2();

    //具体方法
    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //模板方法
    public void TemplateMethod(){
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

}