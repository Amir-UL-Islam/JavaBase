package com.aiokleo.genetics;

public class withGenerics {
    public static void main(String[] args){
        Generics<Integer> printer = new Generics<>(23);
        printer.Print();
        Generics<String> printerSting = new Generics<>("String");
        printerSting.Print();

    }
}
