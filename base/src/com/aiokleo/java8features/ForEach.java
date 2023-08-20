package com.aiokleo.java8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {

        //creating sample Collection
        List<Integer> anyList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            anyList.add(i);
        }

        //traversing using Iterator
        Iterator<Integer> it = anyList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }

/**
 In Java, the Consumer interface is a functional interface that represents an operation that takes a single input argument and does not return any result. It is part of the Java 8's functional programming enhancements and is found in the java.util.function package.

 The Consumer interface has a single abstract method called accept(Object). This method takes an argument of type Object (the input argument) and performs some operation on it. The method does not return any result.

 The purpose of the Consumer interface is to represent an action or behavior that can be performed on an object. It is commonly used in functional programming scenarios where you need to process or operate on objects without returning a result.
 <pre>

 {@code
 import java.util.Arrays;
 import java.util.List;
 import java.util.function.Consumer;

 public class ConsumerExample {
 public static void main(String[] args) {
 List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

 // Using a Consumer to print each element of the list
 Consumer<String> printConsumer = (String name) -> System.out.println(name);
 names.forEach(printConsumer);
 }
 }
 }
 </pre>

 // In the example, we create a Consumer called printConsumer that takes a String argument and prints it. We then use the forEach method of the List interface to apply the printConsumer to each element of the names list.
 **/


        //traversing through forEach method of Iterable with anonymous class
        anyList.forEach(new Consumer<Integer>() {

            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::" + t);
            }

        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        anyList.forEach(action);

    }

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::" + t);
    }
}
