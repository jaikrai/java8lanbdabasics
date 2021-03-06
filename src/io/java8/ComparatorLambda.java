package io.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
    public static void main(String[] args) {


//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        };
        Comparator<String> comparator =
                (String s1, String s2) -> Integer.compare(s1.length(),s2.length());
        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list,comparator);

        for (String s : list){
            System.out.println(s);
        }
    }
}
