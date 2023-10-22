package com.aiokleo.abstraction;

import com.aiokleo.annotation.custom_annotation.RunImmediately;
import com.aiokleo.annotation.custom_annotation.Stater;

@Stater
public abstract class Animals implements Human{
    public String IHate = "Cats";
    public String ILove = "Dogs";
//    public void makeNoise(){} // There Different Animals Sounds Differently.
                                // So, It's not make Scene to Implement HERE;
                                /// Then MAKE the method ABSTRACT and NOT Define the body.

    // Abstract Class can Hold both Abstract and Non-Abstract Method -> Have body and definition LIKE Below
//    @Stater
    public void nonAbstractMethod() {
        System.out.println("Non-Abstract Method -> Have body and definition LIKE This One");
    }
    @RunImmediately(runTimes = 3)
    public void nonAbstractMethodAnnotated(){
        System.out.println("RUN Immediately");

    }
    public abstract void abstractMethod();
}
