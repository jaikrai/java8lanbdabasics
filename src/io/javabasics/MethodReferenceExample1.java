package io.javabasics;

public class MethodReferenceExample1 {
    public static void main(String[] args) {
        Thread t = new Thread(MethodReferenceExample1::printMessage);
        // MethodReferenceExample1::printMessage === () -> printMessage()
        t.start();
    }


    private static void printMessage() {
        System.out.println("Hello");
    }
}
