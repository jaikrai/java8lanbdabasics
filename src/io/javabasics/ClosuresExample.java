package io.javabasics;

public class ClosuresExample {
    public static void main(String[] args) {
        int a = 20;
        int b = 3;
        doPrecess(a, i -> System.out.println(i+b));
    }

    public static void doPrecess(int i, Process p) {
        p.process(i);
    }
}
