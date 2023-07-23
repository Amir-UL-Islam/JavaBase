package com.aiokleo.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Employee> empList = getEmpList();
        // Filtering
        empList.stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .filter(employee -> employee.getSalary() > 10000)
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary()));

        // Counting
//        The java.lang.Math.toIntExact() returns the value of long argument. It will throw an exception if the result overflows either int or long.
        Integer c = Math.toIntExact(empList.stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .filter(employee -> employee.getSalary() > 10000).count());
        System.out.println(c);

        // Sorting
        empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary()));

        // Finding the Match
        Boolean anyMatch = empList.stream()
                .filter(employee -> employee.getGender().equals("Male"))
                .anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch); // True : There are several matches for salary > 10000

//        // Max Function the min function is similar
        empList.stream()
                .filter(employee -> employee.getSalary() > 10000)
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary()));


        empList.stream()
                // the line below will return something like this Map<String, List<Employee>> groupByGender
                .collect(Collectors.groupingBy(Employee::getGender)).forEach((g, e) -> {
                    System.out.println(g);
                    e.forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary()));
                });

    }

    public static List<Employee> getEmpList() {
        return Arrays.asList(
                new Employee("59-385-1088", "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "True", 101146, 0),
                new Employee("73-274-6476", "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
                new Employee("85-939-9584", "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
                new Employee("08-180-8292", "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
                new Employee("21-825-2623", "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
                new Employee("66-708-5539", "Tailor", "Ridding", "Ridding", "Female", "FALSE", 152924, 4),
                new Employee("81-697-2363", "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE", 128907, 0),
                new Employee("63-019-1110", "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Male", "TRUE", 2510, 0)
        );
    }
}
