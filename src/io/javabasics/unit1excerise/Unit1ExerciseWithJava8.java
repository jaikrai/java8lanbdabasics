package io.javabasics.unit1excerise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExerciseWithJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charlie", "Brown", 56),
                new Person("Nick", "Young", 37),
                new Person("Daven", "Ricky", 24),
                new Person("Rick", "Ross", 45),
                new Person("Martin", "Luther", 70)
        );

        // Step 1: Sort list by last name
        Collections.sort(people, Comparator.comparing(Person::getLastName));
//        Collections.sort(people, (p1, p2)->p1.getLastName().compareTo(p2.getLastName()));


        // Step 2: Create a method that prints all elements in the list
        System.out.println("Print all persons");
        performConditionally(people, p -> true, p-> System.out.println(p));
        System.out.println();


        // Step 3: Create a method that prints all people that have last name beginning with C
        System.out.println("Print all persons lastName with R");
        performConditionally(people, p -> p.getLastName().startsWith("R"), p-> System.out.println(p));

        System.out.println();
        System.out.println("Print all persons firstName with R");
        performConditionally(people, p -> p.getFirstName().startsWith("R"), p-> System.out.println(p.getFirstName()));
    }

    // Consumer -- functional interface that accepts a single input argument and returns no result
    //
    // predicate takes an object and returns the boolean
    public  static  void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for (Person p : people){
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
    }
}
