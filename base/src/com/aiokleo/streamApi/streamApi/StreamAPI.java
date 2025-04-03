package com.aiokleo.streamApi.streamApi;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI{
    public static void main(String[] args){
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        System.out.printf(streamOfCollection.map(String::toUpperCase).collect(Collectors.joining(", ")));

    }
}
