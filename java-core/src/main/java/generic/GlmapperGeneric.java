package generic;

/**
 * @Author: Kevin
 * @Date: 2021/9/30 19:34
 * @Description:
 */
public class GlmapperGeneric<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        noSpecifyType();
        specifyType();
    }

    //不指定类型
    public static void noSpecifyType() {
        GlmapperGeneric glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("kevin");
        // 需要强制类型转换
        String res = (String) glmapperGeneric.get();
        System.out.println(res);
    }

    //指定类型
    public static void specifyType() {
        GlmapperGeneric<String> glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("kevin-Durant");
        String res2 = glmapperGeneric.get();
        System.out.println(res2);
    }

}