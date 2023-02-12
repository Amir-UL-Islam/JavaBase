package com.aiokleo.comparator_comparable.comparator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

//Shortest Approach
class Student{
    public int Id;
    public String name;
    public float CGPA;

    public Student(int Id, String name, float CGPA) {
        this.Id = Id;
        this.name = name;
        this.CGPA = CGPA;
    }
}
class Checker implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.CGPA == b.CGPA) {
            if (a.name.equals(b.name)) {
                if (a.Id > b.Id) {
                    return 1;
                }
            } else if (a.name.compareToIgnoreCase(b.name) > 1) {
                return 1;
            } else {
                return -1;
            }
        } else if (a.CGPA > b.CGPA) {
            return 1;
        }
        return -1;
    }

}

public class ComparatorSort {
    private static final Checker checker = new Checker();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nStudent = Integer.parseInt(in.nextLine());

        Student[] students = new Student[nStudent];
        for (int student = 0; student < nStudent; student ++){
            students[student] = new Student(in.nextInt(), in.next(), in.nextFloat());
        }


        Arrays.sort(students, Collections.reverseOrder(checker));
        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i].name);
        }
        in.close();
    }

}
