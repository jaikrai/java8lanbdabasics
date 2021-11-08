package io.javabasics.collections;

import io.javabasics.unit1excerise.Person;

import java.util.Arrays;
import java.util.List;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charlie", "Brown", 56),
                new Person("Nick", "Young", 37),
                new Person("Daven", "Ricky", 24),
                new Person("Rick", "Ross", 45),
                new Person("Martin", "Luther", 70)
        );
        people.stream()
                .filter(p ->p.getLastName().startsWith("C"))
                .forEach(p-> System.out.println(p.getFirstName()));
    }



}
