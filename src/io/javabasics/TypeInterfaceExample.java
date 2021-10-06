package io.javabasics;


public class TypeInterfaceExample {
    public static void main(String[] args) {
        StringLengthLambda myLambda = s -> s.length();
        System.out.println(myLambda.getLength("Hello World"));
        // this is type inference in action there are lots of compiler is
        // inferring from the code it is inferring what the return type,
        // input argument all depending on what that interface is
        printLambda(s -> s.length());
    }
    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello Lambda"));
    }
}
