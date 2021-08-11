package function;

import java.util.function.Function;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 16:43
 * @Description:
 * Function函数型接口
 * 有一个输入参数，有一个输出  只要是函数型接口，可以用lambda表达式简化
 */
public class Demo1 {
    public static void main(String[] args) {
        //工具类：输出输入的值
//        Function function=new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function function=(str)->{
            return str;
        };
        System.out.println(function.apply("Kevin"));
    }
}