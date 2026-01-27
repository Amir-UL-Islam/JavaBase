package com.aiokleo.queuePriority;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    int id;
    String name;
    double cgp;

    public Student(int id, String name, double cgp) {
        this.id = id;
        this.name = name;
        this.cgp = cgp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgp() {
        return cgp;
    }

    public void setCgp(double cgp) {
        this.cgp = cgp;
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (this.getCgp() > otherStudent.getCgp()){
            return -1;
        }else if (this.getCgp() < otherStudent.getCgp()){
            return 1;
        }else if( this.getCgp() == otherStudent.getCgp()){
            if(this.getName().compareTo(otherStudent.getName()) < 0){
                return -1;
            }else if (this.getName().compareTo(otherStudent.getName()) > 0){
                return 1;
            }else if (this.getName().compareTo(otherStudent.getName()) == 0){
                if (this.getId() > otherStudent.getId()) {
                    return -1;
                } else if (this.getId() < otherStudent.getId()) {
                    return 1;
                }
            }
        }
        return 1;
    }
}

class Priority{
    public final List<Student> getStudents(List<String> Events) { // Creating the getStudents Method
        List<Student> students = new ArrayList<>();
        PriorityQueue<Student> pQueue = new PriorityQueue<>();
        for(String event:Events){
            if(event.contains("ENTER")){
                String[] s = event.split(" ");
                Student newStudent = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                pQueue.add(newStudent);
            }else
                if (!pQueue.isEmpty()){
                pQueue.remove();
            }
        }
        while (!pQueue.isEmpty()){
            Student student = pQueue.peek();
            students.add(student);
            pQueue.remove();
        }
        return students;
    }
}

public class Solution{
    private final static Priority priorities = new Priority();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalEvents = Integer.parseInt(br.readLine().trim());
        List<String> Events = new ArrayList<>();
        while (totalEvents --> 0){
            String line = br.readLine().trim();
            Events.add(line);
        }
        // Adding the Events to Priority Queue
        List<Student> students = priorities.getStudents(Events);
        if(students.isEmpty()){
            System.out.print("EMPTY");
        }else {
            for (Student st: students){
                System.out.println(st.getName());
            }
        }
    }

}
