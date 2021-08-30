package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Kevin
 * @Date: 2021/8/25 22:38
 * @Description: 使用LinkedHashMap实现一个简易的LRU缓存
 */
public class SimpleLRUCache<K,V> {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY=0.75f;

    LinkedHashMap<K,V> map;
    public SimpleLRUCache(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;

        map=new LinkedHashMap<K,V>(capacity,DEFAULT_LOAD_FACTORY,true){
            private static final long serialVersionUID = 1L;
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size()>MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void remove(K key){
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getALl(){
        return map.entrySet();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K,V> entry: map.entrySet()){
            stringBuilder.append(String.format("%s: %s",entry.getKey(),entry.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SimpleLRUCache<String, String> lru = new SimpleLRUCache<>(5);
        lru.put("球员1", "杜兰特");
        lru.put("球员2", "表妹");
        lru.put("球员3", "库里");
        System.out.println(lru);
        lru.get("球员1");
        System.out.println(lru);
        lru.put("球员4", "一哥");
        lru.put("球员5", "汤姆");
        System.out.println(lru);
        lru.put("球员6", "格林");
        System.out.println(lru);
    }
}