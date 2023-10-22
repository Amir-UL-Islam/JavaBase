package com.aiokleo;
//    A package in Java is used to group related classes.
//    Think of it as a folder in a file directory.
//    We use packages to avoid name conflicts,
//    And to write a better maintainable code.

//   - Built-in Packages (packages from the Java API)
//   - User-defined Packages (create your own packages)

//import package.name.Class;   // Import a single class
//import package.name.*;   // Import the whole package

import java.util.Scanner; // Import a Single Class(Scanner)
import java.util.*; // Importing a Package

public class PackagesAPI {
    public static void main(String[] args){
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter username: ");

        String userName = Input.nextLine();
        System.out.println("Username is: " + userName);
    }
}
