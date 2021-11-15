package io.java8.stream;

import io.java8.stream.modal.People3;
import io.java8.stream.modal.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {
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
        List<People3> list1 = persons.subList(1, 5);
        List<People3> list2 = persons.subList(5, persons.size());
        System.out.println("********");
        Map<Integer, List<People3>> mymap = mapByAge(list1);
        mymap.forEach((age, list) -> System.out.println(age+" ->"+ list));
        Map<Integer, List<People3>> mymap1 = mapByAge(list2);
        mymap1.forEach((age, list) -> System.out.println(age+" ->"+ list));

        mymap1.entrySet().stream()
                .forEach(entry -> mymap.merge(entry.getKey(), entry.getValue(), (l1, l2)->{
                    l1.addAll(l2);
                    return l1;
                }));
        System.out.println("Map merged");
        mymap.forEach((age, list) -> System.out.println(age+" ->"+ list));

    }
    private static Map<Integer, List<People3>> mapByAge(List<People3> list){
        Map<Integer, List<People3>> map = list.stream().
                collect(Collectors.groupingBy(People3::getAge));
        return map;
    }

}
