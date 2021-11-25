package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/**
 * @Author: Kevin
 * @Date: 2021/11/11 22:31
 * @Description:
 */
public class TestAnnotation {
    public static void main(String[] args) {
        Class recordC=null;
        try {
            recordC=Class.forName("annotation.Record");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("------ 构造方法的描述如下 ------");
        Constructor[] declaredConstructors = recordC
                .getDeclaredConstructors(); // 获得所有构造方法
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor constructor = declaredConstructors[i]; // 遍历构造方法
            // 查看是否具有指定类型的注释
            if (constructor
                    .isAnnotationPresent(Constructor_Annotation.class)) {
                // 获得指定类型的注释
                Constructor_Annotation ca = (Constructor_Annotation) constructor
                        .getAnnotation(Constructor_Annotation.class);
                System.out.println(ca.value()); // 获得注释信息
            }
            Annotation[][] parameterAnnotations = constructor
                    .getParameterAnnotations(); // 获得参数的注释
            for (int j = 0; j < parameterAnnotations.length; j++) {
                // 获得指定参数注释的长度
                int length = parameterAnnotations[j].length;
                if (length == 0) // 如果长度为0则表示没有为该参数添加注释
                    System.out.println("    未添加Annotation的参数");
                else
                    for (int k = 0; k < length; k++) {
                        // 获得参数的注释
                        Field_Method_Parameter_Annotation pa = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.print("    " + pa.descrblic()); // 获得参数描述
                        System.out.println("    " + pa.type()); // 获得参数类型
                    }
            }
            System.out.println();
        }

        System.out.println();

    }
}