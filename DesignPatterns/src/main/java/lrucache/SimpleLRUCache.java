//package lrucache;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @Author: Kevin
// * @Date: 2021/8/25 22:38
// * @Description: 使用LinkedHashMap实现一个简易的LRU缓存
// */
//public class SimpleLRUCache<K,V> {
//    private final int MAX_CACHE_SIZE;
//    private final float DEFAULT_LOAD_FACTORY=0.75f;
//
//    LinkedHashMap<K,V> map;
//    public SimpleLRUCache(int cacheSize) {
//        this.MAX_CACHE_SIZE = cacheSize;
//        int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;
//        map=new LinkedHashMap<K,V>(capacity,DEFAULT_LOAD_FACTORY,true){
//            private static final long serialVersionUID = 1L;
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
////                return size();
//            }
//        };
//    }
//}