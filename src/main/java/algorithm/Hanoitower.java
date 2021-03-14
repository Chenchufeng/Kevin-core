package algorithm;

/**
 * @Author: chufeng Chen
 * @Description: 分治算法实现汉诺塔问题
 * @Date:Create：in 2021/3/14 20:41
 */

/**分治算法的基本步骤：
 * 分解：将原问题分解为若干个规模较小，相互独立，与原问题形势相同的子问题
 * 解决：若子问题规模较小容易被解决则直接解，否则递归的解各个子问题
 * 合并：将各个子问题的解合并为原问题的解
 * 思路分析：有A,B,C三个盘
 * 1.如果只有一个盘，A->C
 * 2.如果我们有n>=2情况：
 *  1)先把最上面的盘 A->B
 *  2)把最下面的盘 A->C
 *  3)把B塔的所有盘 B->C
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(10,'A','B','C');
    }

    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //如果我们有n>=2情况,可以看成是2个盘，最上面的所有盘和最下面的一个盘
            //1.把最上面的所有盘，从A->B,移动过程会使用到C塔
            hanoiTower(num-1,a,c,b);
            //2.把最下面的盘，从A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把B塔所有的盘移动到C,移动过程使用到A塔
            hanoiTower(num-1,b,a,c);
        }

    }
}
