package com.aiokleo.abstraction;

import java.util.Scanner;

public class Abstraction101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyBook book = new MyBook();
        book.setTitle(sc.nextLine());
        System.out.println("The title is: " + book.getTitle());
    }
}
abstract class Book{
    abstract void setTitle(String s);
}
class MyBook extends Book{
    String title;
    @Override
    void setTitle(String s) {
        this.title = s;
    }
    String getTitle(){
        return this.title;
    }
}

