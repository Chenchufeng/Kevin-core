package unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: Kevin
 * @Date: 2021/7/21 23:14
 * @Description:
 * 同理可证 ： ConcurrentModificationException
 *
 */
public class SetTest {
    public static void main(String[] args) {
        //1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set =  new CopyOnWriteArraySet<>();

        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}