package com.aiokleo.annotation.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {
    // Adding Parameters to The Annotation
    // Also the Default Values

    int runTimes() default 4;
}
