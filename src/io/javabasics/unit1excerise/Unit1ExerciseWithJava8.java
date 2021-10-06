package io.javabasics.unit1excerise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        printAll(people);
        System.out.println();


        // Step 3: Create a method that prints all people that have last name beginning with C
        System.out.println("Print all persons lastName with R");
        printConditionally(people,p -> p.getLastName().startsWith("R"));

        System.out.println();
        System.out.println("Print all persons firstName with R");
        printConditionally(people, p -> p.getFirstName().startsWith("R"));
    }
    public  static  void printConditionally(List<Person> people,Condition condition){
        for (Person p : people){
            if (condition.test(p)){
                System.out.println(p);
            }
        }
    }
    public static void printAll(List<Person> p){
        for (Person per : p){
            System.out.println(per);
        }
    }
}
