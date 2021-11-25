package freecoder.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Kevin
 * @Date: 2021/11/25 22:51
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.age = 23;
        getObject(person);
    }

    public static void getObject(Object object) {
        Class c = object.getClass();
        Field field = null;
        try {
            field = c.getDeclaredField("age");
            Method method = c.getDeclaredMethod("sayHello");
            System.out.println(field.getInt(object));
            method.setAccessible(true);
            method.invoke(object);
            System.out.println(c.isAnnotationPresent(MyAnno.class));
            System.out.println(field.getDeclaredAnnotation(MyAnno.class).name());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}