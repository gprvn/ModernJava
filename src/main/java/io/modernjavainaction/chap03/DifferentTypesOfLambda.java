package io.modernjavainaction.chap03;

public class DifferentTypesOfLambda {
    public static void main(String[] args) {
//        Object o = () -> {
//            System.out.println("Object is not a functional interface");
//        };
        System.out.println(Thread.currentThread().getName());

        Runnable runnable_is_a_functional_interface = () -> System.out.println(Thread.currentThread().getName());
        new Thread(runnable_is_a_functional_interface).start();

        //Using local variables
        int portNumber = 234567;
        Runnable runnable = () -> System.out.println(portNumber);
        new Thread(runnable).start();

        /**
         * difference between Instance and Local variable:
         * Instance variable are stored on the heap, whereas Local variable stored in stack.
         */
    }
}
