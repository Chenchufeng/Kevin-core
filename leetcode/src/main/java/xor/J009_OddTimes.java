package xor;

import utils.TestUtils;

/**
 * @Author: Kevin
 * @Date: 2021/10/3 10:57
 * @Description:
 */
public class J009_OddTimes {
    public static void main(String[] args) {
        int[] arrays2 = {4, 5, 5, 5, 4, 7, 6, 8, 6, 7, 7, 7};
        int[] result = twoOddTimes(arrays2);
        TestUtils.printArray(result);
    }



    private static int[] twoOddTimes(int[] arrays) {
        if (arrays==null || arrays.length==1){
            return arrays;
        }
        if (arrays.length==2){
            return arrays;
        }
        //所有的数异或一遍得到 eor = a^b
        //既然a和b异或不等于0，那么a和b的某一位肯定不相同，要么a等于1，b等于0，要么a等于0，b等于1
        int eor=0;
        for (int i = 0; i < arrays.length; i++) {
            eor^=arrays[i];
        }
        int eor1=0;
        //提取二进制最右侧的1
        int rightOne=eor&(~eor+1);
        //找出所有数中这个位置为1的数，其中包含了出现奇数次的其中一个
        for (int i = 0; i < arrays.length; i++) {
            //那么将这些数异或就得到了a或者b，即eor1, 因为其他的数都是偶数，会被异或掉
            if ((arrays[i]&rightOne)!=0){
                eor1^=arrays[i];
            }
        }
        //a^b^? -> ?是a或者b 那么异或出来就剩下一个不相同的
        int eor2=eor^eor1;
        return new int[]{eor1,eor2};
    }

}