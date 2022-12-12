package com.aiokleo.varKeyword;

import java.util.List;

public class UseOfVar {
    public static void main(String[] args) {
//        Instead of using Int using ver;
        var a = 12;
        var b = 3;
        var c = 7;
        System.out.println(a + b);
        System.out.println(c + 5);

        List<String> IWantTo = List.of("Eat", "Travel", "Sing");
        IWantTo.forEach(System.out::println);

//        Same thing with Var Keyword
        var IWantToDo = List.of("Eat", "Sing", "Work", "Travel");
        IWantToDo.forEach(iw -> System.out.print(iw));


    }
}
