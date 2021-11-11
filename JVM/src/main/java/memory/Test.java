package memory;

/**
 * @Author: Kevin
 * @Date: 2021/10/14 21:43
 * @Description:
 */
public class Test {
    public static void main1(String[] args) {
        // "a" "b" 被放入串池中，str 则存在于堆内存之中
        String str = new String("a") + new String("b");
        // 调用 str 的 intern 方法，这时串池中没有 "ab" ，则会将该字符串对象放入到串池中，此时堆内存与串池中的 "ab" 是同一个对象
        String st2 = str.intern();
        // 给 str3 赋值，因为此时串池中已有 "ab" ，则直接将串池中的内容返回
        String str3 = "ab";
        // 因为堆内存与串池中的 "ab" 是同一个对象，所以以下两条语句打印的都为 true
        System.out.println(str == st2);
        System.out.println(str == str3);
    }

    public static void main(String[] args) {
        // 此处创建字符串对象 "ab" ，因为串池中还没有 "ab" ，所以将其放入串池中
        String str3 = "ab";
        // "a" "b" 被放入串池中，str 则存在于堆内存之中
        String str = new String("a") + new String("b");
        // 此时因为在创建 str3 时，"ab" 已存在与串池中，所以放入失败，但是会返回串池中的 "ab"
        String str2 = str.intern();
        // false
        System.out.println(str == str2);
        // false
        System.out.println(str == str3);
        // true
        System.out.println(str2 == str3);
    }

}