package com.aiokleo.singleton;
// SingleTon mean allowing A CLASS to CREATE 1 INSTANCE

public class Singleton {
    public static void main(String[] args){
        ABC abcOne = ABC.getInstance();
//        I can't do
//        ```
//        ABC abcTwo = new ABC();
//        ```
//        BECAUSE ABC is a Private
//        SO I have to go with this
        ABC abcTwo = ABC.getInstance();
//        Which will return same Instance
    }
}


//STEPs of CREATing Singleton

class ABC{

    //    1st STEP
    static ABC abc = new ABC(); // Because the getInstance() is a Static Method to do abc OBJECT.
    //    2nd STEP
    private ABC(){

    }
//    3rd STEP
    public static ABC getInstance(){
        System.out.println("Only 1 Instance");
        return abc; // allowing only one Instance
    }
}
