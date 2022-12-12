package com.aiokleo.genetics.withOutGenerics;
// Thing is If I want to Print a String I have to Recreate Same constructor and Methods
// Here The Generics Come in Play

public class withOutGenerics {
    Integer SomeThingInteger;
    public withOutGenerics(Integer SomeThingInteger){ // a constructor

        this.SomeThingInteger = SomeThingInteger;
    }

    public void Print(){
        System.out.println(SomeThingInteger);
    }

}
