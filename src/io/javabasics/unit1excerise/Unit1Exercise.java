package io.javabasics.unit1excerise;

import java.util.*;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charlie", "Brown", 56),
                new Person("Nick", "Young", 37),
                new Person("Daven", "Ricky", 24),
                new Person("Rick", "Ross", 45),
                new Person("Martin", "Luther", 70)
        );

        // Step 1: Sort list by last name
        // Old way
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });


        // Step 2: Create a method that prints all elements in the list
        System.out.println("Print all persons");
        printAll(people);

        // Step 3: Create a method that prints all people that have last name beginning with C
        // OLD way
        System.out.println("Print all persons lastName with R");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person person) {
                return person.getLastName().startsWith("R");
            }
        });
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
