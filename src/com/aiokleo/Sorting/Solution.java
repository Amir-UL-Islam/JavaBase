package com.aiokleo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.*;

//Shortest Approach
class Student{
    public int Id;
    public String name;
    public double CGPA;

    public Student(int Id, String name, double CGPA) {
        this.Id = Id;
        this.name = name;
        this.CGPA = CGPA;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nStudent = Integer.parseInt(in.nextLine());

        ArrayList<Student> students = new ArrayList<>();
        for (int student = 0; student < nStudent; student++) {
            students.set(student, new Student(in.nextInt(), in.next(), in.nextDouble()));
        }

        students.sort(
                Comparator
                        .comparing(Student::getCGPA)
                        .reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId)
        );
    }

}

