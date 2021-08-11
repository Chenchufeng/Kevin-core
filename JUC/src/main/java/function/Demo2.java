package function;

import java.util.function.Predicate;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 17:19
 * @Description:
 * 断定型接口，有一个输入参数，返回值只能是布尔值
 */
public class Demo2 {
    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate=new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate=(String str)->{
          return str.isEmpty();
        };
        System.out.println(predicate.test("123"));
    }
}