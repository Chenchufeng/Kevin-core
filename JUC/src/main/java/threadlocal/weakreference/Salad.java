package threadlocal.weakreference;

import java.lang.ref.WeakReference;

/**
 * @Author: Kevin
 * @Date: 2021/8/24 23:37
 * @Description:
 * Salad class
 *  * 继承WeakReference，将Apple作为弱引用。
 *  * 注意到时候回收的是Apple，而不是Salad
 */
public class Salad extends WeakReference<Apple> {
    public Salad(Apple apple) {
        super(apple);
    }
}