package io.javabasics;

public class TypeInterfaceExample {
    public static void main(String[] args) {
        StringLengthLambda myLambda = s -> s.length();
        System.out.println(myLambda.getLength("Hello World"));
        printLambda(s -> s.length());
    }
    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello Lambda"));
    }
}
