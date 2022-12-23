package com.aiokleo.abstraction;

public class JavaAbstraction{
//    Data abstraction is the process of hiding certain details
//    And showing only essential information to the user.

//    Abstract class: is a restricted class that cannot be used to create objects
//    (to access it, it must be inherited from another class).

//    Abstract method: can only be used in an abstract class,
//    And it does not have a body. The body is provided by the subclass (inherited from).
public static void main(String[] args) {
//    AbstractDot Dog = new AbstractDot(); // I can Instantiate the AbstractDot Class When it is Not ABSTRACT
                                        // After making it Abstract it Throws Errors When We Try to Instantiate
                                       // java: com.aiokleo.AbstractDot is abstract; cannot be instantiated
//    Animals Dog = new AbstractDog();  Using Polymorphism
    // As AbstractDog class is Extended by Animals Abstract Class
    // So AbstractDog can be Assigned to Animals Abstract class Reference
    // That is why it worked.
    AbstractDog Dog = new AbstractDog();
    Dog.abstractMethod();
    Dog.EveryThing();
    Dog.nonAbstractMethod();

}

}
