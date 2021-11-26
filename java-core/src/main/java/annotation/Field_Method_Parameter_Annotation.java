package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})  // 用于字段、方法和参数
@Retention(RetentionPolicy.RUNTIME)  // 在运行时加载Annotation到JVM中
public @interface Field_Method_Parameter_Annotation {
    String descrblic();     // 定义一个没有默认值的String型成员
    Class type() default void.class;  // 定义一个具有默认值的Class型成员
}
