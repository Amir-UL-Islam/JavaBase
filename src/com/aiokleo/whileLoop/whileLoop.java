package com.aiokleo.whileLoop;

import java.util.Scanner;

public class whileLoop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")){
            input = scan.nextLine().trim().toLowerCase();
            if (!input.equals("quit"))
                System.out.println(input);

        }
    }

}
