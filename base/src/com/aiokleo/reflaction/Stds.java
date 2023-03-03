package com.aiokleo.reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Stds {
    public int roll ;
    private String name;
    public int age;
    private final String address;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public Stds(int roll, String name, int age, String address) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String startWith(String name, String startWith){
        return name.startsWith(startWith) ? "Yes" : "No";
    }
    public static String endWith(String name, String endWith){
        return name.endsWith(endWith) ? "Yes" : "No";
    }
    private void print(){
        System.out.println("Roll: " + roll + ", Name: " + name + ", Age: " + age + ", Address: " + address);
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Stds stds = new Stds(1, "Aio", 20, "83, Sadek Khan Road, Dhaka");
//        System.out.println(student.startWith(student.getName(), "A"));
//        System.out.println(Student.endWith(student.getName(), "o"));
        Field[] fields = stds.getClass().getFields();
//        System.out.println(Arrays.stream(fields).collect(Collectors.toList()));
        for(Field field : fields){
            if(field.getName().equals("address")){
                field.setAccessible(true);
                field.set(stds.address, "83, Sadek Khan Road, Dhaka, Bangladesh");
            }
            System.out.println(field.get(stds));
        }

        Method[] methods = stds.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().equals("startWith") && method.getParameterCount() == 2){
                System.out.println(method.invoke(stds, stds.getName(), "A"));
            }
            if(method.getName().equals("endWith") && method.getParameterCount() == 2){
                System.out.println(method.invoke(null, stds.getName(), "o"));
            }
            if(method.getName().equals("print") && method.getParameterCount() == 0){
//                method.setAccessible(true);
                method.invoke(stds);
            }
        }

    }
}
