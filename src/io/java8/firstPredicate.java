package io.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class firstPredicate {
    public static void main(String[] args) {
        Stream<String > stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s->s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
        List<String> list = new ArrayList<>();
        stream.peek(System.out::println)
                .filter(p2.or(p3))
                .forEach(list::add);
        System.out.println("Done!");
        System.out.println("site = " + list.size());
    }
}
