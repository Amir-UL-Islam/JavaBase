package com.aiokleo.whileLoop;

import java.util.Scanner;

public class whileLoop01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (true){
            System.out.print("Input: ");
            input = scan.next().trim().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println(input);

        }
    }
}
