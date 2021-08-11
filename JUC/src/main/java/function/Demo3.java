package function;

import java.util.function.Consumer;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 17:26
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) {
        //消费型接口，没有返回值
        Consumer consumer=new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        consumer.accept("Kevin Chen");
    }
}