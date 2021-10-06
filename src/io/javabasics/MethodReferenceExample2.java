package io.javabasics;

import io.javabasics.unit1excerise.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static io.javabasics.unit1excerise.Unit1ExerciseWithJava8.performConditionally;

public class MethodReferenceExample2 {
        public static void main(String[] args) {
            List<Person> people = Arrays.asList(
                    new Person("Charlie", "Brown", 56),
                    new Person("Nick", "Young", 37),
                    new Person("Daven", "Ricky", 24),
                    new Person("Rick", "Ross", 45),
                    new Person("Martin", "Luther", 70)
            );

            System.out.println("Print all persons");
//            performConditionally(people, p -> true, p -> System.out.println(p));
            performConditionally(people, p -> true, System.out::println); // p-> method(p)

        }
        public  static  void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
            for (Person p : people){
                if (predicate.test(p)){
                    consumer.accept(p);
                }
            }
        }
}
