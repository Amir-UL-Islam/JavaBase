package com.aiokleo.annotation;

import com.aiokleo.abstraction.AbstractDog;
import com.aiokleo.abstraction.Animals;
import com.aiokleo.annotation.custom_annotation.RunImmediately;
import com.aiokleo.annotation.custom_annotation.VeryImportant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unused") // Using for remove Warnings
        AbstractDog Dog = new AbstractDog();

        // The class has Annotation or Not
        System.out.println(Dog.getClass().isAnnotationPresent(VeryImportant.class));

        // Checking If the Method is Annotated or Not
        for (Method method : Dog.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                // Giving the Value of numTimes parameter
                    // 1. Getting the Annotation
                    // 2. Getting the Value of the Annotation
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int invoke = 0; invoke < annotation.runTimes(); invoke++){ // the number of times want to invoke the method
                    method.invoke(Dog);
                };
            }
        }
    }

}
