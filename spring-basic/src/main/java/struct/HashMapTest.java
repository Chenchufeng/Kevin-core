package struct;

import java.util.HashMap;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/4/6 22:28
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        String value=map.put("1","3");
        System.out.println(value);
    }
}
