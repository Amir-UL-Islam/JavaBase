package com.aiokleo.CovariantReturnTypes;

// Before covariant return Type was Introduced
// We can't change the return type of the overridden method
// Say:
class A {
    // I want to change the return type of the class A
    A withaMethodCalledA() { // The Notable Fact is
                             // We are Changing the Return Type of the Method A to B
        System.out.println("From A");
//        return new A(); // or
        return this; // Here both will work fine.
        // Because (This) key word Refers to the Object of the current class
        // And we create by using (new ClassName())
    }

}

class B extends A {
    @Override
    B withaMethodCalledA() {
        super.withaMethodCalledA(); // Only if we want to call the method of the super class( in this case the A Class)
        System.out.println("From B");
        return new B();
    }
}

public class CovariantReturnTypes {
    public static void main(String[] args) {
        B b = new B();
        b.withaMethodCalledA();
    }
}