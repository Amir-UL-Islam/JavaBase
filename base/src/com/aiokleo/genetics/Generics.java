package com.aiokleo.genetics;
public class Generics<T> { // Type parameter <T>
   T SomeThingToPrint;
   public Generics(T SomeThingToPrint){
       this.SomeThingToPrint = SomeThingToPrint;
   }
   public void Print(){
       System.out.println(SomeThingToPrint);
   }
}
