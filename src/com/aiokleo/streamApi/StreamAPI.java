package com.aiokleo.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Employee> empList = getEmpList();
        // Filtering
//        empList.stream()
//                .filter(employee -> employee.getGender().equals("Male"))
//                .filter(employee -> employee.getSalary() > 10000)
//                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary()));

        // Counting
//        The java.lang.Math.toIntExact() returns the value of long argument. It will throw an exception if the result overflows either int or long.
//        Integer c = Math.toIntExact(empList.stream()
//                .filter(employee -> employee.getGender().equals("Male"))
//                .filter(employee -> employee.getSalary() > 10000).count());
//        System.out.println(c);

        // Sorting
//        empList.stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary()));

        // Finding the Match
//        Boolean anyMatch = empList.stream()
//                .filter(employee -> employee.getGender().equals("Male"))
//                .anyMatch(employee -> employee.getSalary() > 10000);
//        System.out.println(anyMatch); // True : There are several matches for salary > 10000

//        // Max Function the min function is similar
//        empList.stream()
//                .filter(employee -> employee.getSalary() > 10000)
//                .max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary()));


        // the line below will return something like this Map<String, List<Employee>> groupByGender
        Map<String, List<Employee>> e = empList.stream()
                .collect(Collectors.groupingBy(Employee::getId));
        List<Employee> e2 = new ArrayList<>();
        for (List<Employee> ef : e.values()) {
            if (ef.size() > 1) {
                e2.add(ef.get(0));
            } else {
                e2.add(ef.get(0));
            }
        }
        System.out.println(e2.stream().filter(ee -> ee.getSalary() < 100000).count());

    }

    public static List<Employee> getEmpList() {
        return Arrays.asList(
                new Employee("1", "Male", 101146),
                new Employee("1", "Female", 29310),
                new Employee("3", "Female", 62291),
                new Employee("4", "Male", 142439),
                new Employee("2", "Male", 128764)
        );
    }
}
