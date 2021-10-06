package io.javabasics;

public class RunnableExample {
    public static void main(String[] args) {

        // this is the classic use of using Runnable interface
        // with the single method of run
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        myThread.run();

        // this is the use of lambda implementation of an  interface --
        // this use of interface is called functional interface
        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Lambda runnable"));
        myLambdaThread.run();
    }
}
