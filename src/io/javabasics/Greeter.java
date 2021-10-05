package io.javabasics;

public class Greeter {
    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting helloWorldGreeting = new HelloWorldGreeting();

        Greeting myLambdaFunction = () -> System.out.println("lambda Hello world!");
        Greeting greeting = new Greeting() {
            public void perform(){
                System.out.println("New world");
            }
        };

//        greeter.greet(helloWorldGreeting);
//        myLambdaFunction.perform();
//        greeting.perform();
        greeter.greet(myLambdaFunction);
        greeter.greet(greeting);
    }
}
