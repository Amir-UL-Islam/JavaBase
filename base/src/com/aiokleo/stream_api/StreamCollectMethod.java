package com.aiokleo.stream_api;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamCollectMethod {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};

        // Creating a List from an array of elements
        // using Arrays.asList() method
//        Array is a data structure generally consisting of sequential memory storing a collection of objects. List is an interface in Java, which means that it may have multiple implementations.
        List<Integer> list = Arrays.asList(intArray);

        // finding the sum of all the values
        // in the stream
        Integer sum = list.stream()
                .collect(summingInt(i -> i));
        System.out.println(sum);

        // Collecting all elements of the list into a new
        // list using collect() method
        List<Integer> evenNumbersList = list.stream()
                .filter(i -> i%2 == 0)
                .collect(toList());
        System.out.println(evenNumbersList);


        // finding the maximum of all the values
        // in the stream
        Integer max = list.stream()
//                double colon (::) operator, also known as method reference operator in Java
                .collect(maxBy(Integer::compare)).get();
        System.out.println("max value: " + max);

        // finding the minimum of all the values
        // in the stream
        Integer min = list.stream()
                .collect(minBy(Integer::compare)).get();
        System.out.println("min value: " + min);

        // counting the values in the stream
        Long count = list.stream()
                .count();
        System.out.println(count);
    }
}
