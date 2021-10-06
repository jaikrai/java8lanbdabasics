package io.javabasics.collections;

import io.javabasics.unit1excerise.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charlie", "Brown", 56),
                new Person("Nick", "Young", 37),
                new Person("Daven", "Ricky", 24),
                new Person("Rick", "Ross", 45),
                new Person("Martin", "Luther", 70)
        );
        //
        System.out.println("Using for loop");
        for (int i = 0; i <people.size(); i++){
            System.out.println(people.get(i));
        }
        System.out.println();
        System.out.println("Using for each loop");
        for (Person p : people){
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Using lambda for each loop");
        people.forEach(System.out::println);
    }
}
