package io.java8.stream.modal;

import java.time.LocalDate;

public class Person2 {
    private String name;
    private LocalDate dataOfBirth;

    public Person2(){}
    public Person2(String name, LocalDate dataOfBirth) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                '}';
    }
}
