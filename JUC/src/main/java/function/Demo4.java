package function;

import java.util.function.Supplier;

/**
 * @Author: Kevin
 * @Date: 2021/7/31 17:33
 * @Description:
 */
public class Demo4 {
    //供给型接口，没有参数，只有返回值
    public static void main(String[] args) {
        Supplier supplier=new Supplier() {
            @Override
            public Object get() {
                return 1024;
            }
        };
        System.out.println(supplier.get());
    }
}