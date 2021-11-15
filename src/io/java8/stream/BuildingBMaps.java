package io.java8.stream;

import io.java8.stream.modal.People3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingBMaps {
    public static void main(String[] args) {
        List<People3> persons = new ArrayList<>();
        try(
                BufferedReader reader = new BufferedReader( new InputStreamReader(
                        CollectorsExample.class.getResourceAsStream("people3.txt")));
                Stream<String> stream = reader.lines();
        ){
            stream.map(line ->{
                String[] s = line.split(" ");
                People3 p = new People3(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
               persons .add(p);
                return p;
            }).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
        persons.forEach(System.out::println);
        Map<Integer, List<People3>> map = persons.stream().
                collect(Collectors.groupingBy(People3::getAge));
        map.forEach((age, list)-> System.out.println(age + " -> "+ list));
        Map<Integer, Map<String, List<People3>>> bimap = new HashMap<>();
        persons.forEach(person -> bimap.computeIfAbsent(
                person.getAge(),
                HashMap::new
        ).merge(person.getGender(), new ArrayList<>(Arrays.asList(person)),
                (l1,l2) ->{
            l1.addAll(l2);
            return l1;
                }
        ));
        System.out.println("Bimap");
        bimap.forEach((age, m)-> System.out.println(age+" = "+m));

    }

}
