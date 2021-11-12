package io.java8.stream;

import io.java8.stream.modal.Person;
import io.java8.stream.modal.Person2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateAndTime {
    public static void main(String[] args) {
        List<Person2> persons = new ArrayList<>();

        try(
                BufferedReader reader = new BufferedReader( new InputStreamReader(
                    DateAndTime.class.getResourceAsStream("people2.txt")));
                Stream<String> stream = reader.lines();
        ){
            stream.map(line ->{
                String[] s = line.split(" ");
                String name = s[0].trim();
                int year = Integer.parseInt(s[1]);
                Month month = Month.of(Integer.parseInt(s[2]));
                int day = Integer.parseInt(s[3]);
                Person2 p = new Person2(name, LocalDate.of(year, month, day));
                persons.add(p);
                return p;
            }).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
        LocalDate now = LocalDate.of(2014, Month.AUGUST,12);

        persons.stream().forEach(p->{
            Period period = Period.between(p.getDataOfBirth(), now);
            System.out.println(p.getName() + " was born " +
                    period.get(ChronoUnit.YEARS) + " years and " +
                    period.get(ChronoUnit.MONTHS) + " month " +
                    "[" +p.getDataOfBirth().until(now, ChronoUnit.MONTHS) + " months]");
        });
    }
}
