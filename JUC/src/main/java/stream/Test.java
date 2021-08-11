package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Kevin
 * @Date: 2021/8/1 15:10
 * @Description:
 */
public class Test {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> list = numbers.stream()
                .map(i -> i * i)
                .sorted((x, y) -> x - y)
                .collect(Collectors.toList());
        list.forEach(num->{
//            num++;
            System.out.println(num);
        });
    }
}