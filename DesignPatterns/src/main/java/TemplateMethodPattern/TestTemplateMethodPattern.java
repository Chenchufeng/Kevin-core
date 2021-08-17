package TemplateMethodPattern;

/**
 * @Author: Kevin
 * @Date: 2021/8/16 22:47
 * @Description:
 */
public class TestTemplateMethodPattern {
    public static void main(String[] args) {
//        AbstractClass abstractClass = new AbstractClass() {
//            @Override
//            public void abstractMethod1() {
//                System.out.println("111111");
//            }
//
//            @Override
//            public void abstractMethod2() {
//                System.out.println("222222");
//            }
//        };
//        abstractClass.TemplateMethod();
        AbstractClass abstractClass=new ConcreteClass();
        abstractClass.TemplateMethod();
    }
}