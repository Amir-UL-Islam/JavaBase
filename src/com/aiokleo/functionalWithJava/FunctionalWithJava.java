package com.aiokleo.functionalWithJava;

import kotlin.Unit;

import java.util.function.Function;
import java.util.logging.Logger;

public class FunctionalWithJava {
//    functions are first-class citizens,
//    1. meaning that they can be passed around as values,
//    2. stored in variables or data structures,
//    3. and used as arguments or return values of other functions.

    static Logger logger = Logger.getLogger(FunctionalWithJava.class.getName());

    private static Function<Integer, Integer> multiply = x -> x * 2;

    private static Function<Integer, Integer> add = x -> x + 2;

    private static Function<Integer, Unit> logOutput = x -> {
        logger.info("Data:" + x);
        return Unit.INSTANCE;
    };


    // Notable Fact :
    // andThen will work from left to right
    // compose will work from right to left
    public static Unit execute(Integer input) {
        Function<Integer, Unit> pipeline = multiply
                .andThen(add)
                .andThen(logOutput);
        return pipeline.apply(input);
    }


    public static Unit composeExecute(Integer input) {
        Function<Integer, Unit> pipeline = logOutput
                .compose(add)
                .compose(multiply);
        return pipeline.apply(input);
    }

    public static void main(String[] args) {
        execute(30);
        composeExecute(30);
    }

}
