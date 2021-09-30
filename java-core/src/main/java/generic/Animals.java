package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kevin
 * @Date: 2021/9/30 20:37
 * @Description:
 */
class Animal {
    int countLegs=1;
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs(dogs);
        //报错
//        countLegs1(dogs);
    }

    static int countLegs(List<? extends Animal> list){
        int reVal=0;
        for (Animal animal:list){
            reVal+=animal.countLegs;
        }
        return reVal;
    }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs;
        }
        return retVal;
    }

}

class Dog extends Animal{

}