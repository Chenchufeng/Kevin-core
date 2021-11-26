package freecoder.annotation;

/**
 * @Author: Kevin
 * @Date: 2021/11/25 22:50
 * @Description:
 */
@MyAnno
public class Person {

    @MyAnno(name = "bb")
    public int age;

    @MyAnno
    private void sayHello() {
        System.out.println("hello");
    }

}