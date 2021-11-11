package memory;

/**
 * @Author: Kevin
 * @Date: 2021/10/14 22:05
 * @Description: * 演示 StringTable 垃圾回收
 * * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * -Xmx10m 指定堆内存大小
 * -XX:+PrintStringTableStatistics 打印字符串常量池信息
 * -XX:+PrintGCDetails
 * -verbose:gc 打印 gc 的次数，耗费时间等信息
 */
public class Code_05_StringTableTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 10000; j++) { // j = 100, j = 10000
                String.valueOf(j).intern();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }

}