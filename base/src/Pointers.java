import java.io.*;
import java.awt.*;

public class Pointers{
    static int primitiveType(){
        int x = 5;
        int y = x + 2;
        x = 2;
        return y;
    }


    public static void main(String[] args){
//        System.out.println("To Me");
        Point PointOne = new Point(1, 2); // This Line of code work LIKE in C points
                                                // int *PointOne; Defining a pointer LOCATION.
                                                // int n = 50;
                                                // PointOne = &n; Storing the LOCATION of the Value n.
                                                // C language does not allow pointer COPPING so DOES JAVA

        System.out.println("The value of x: " + PointOne.x);
        Point PointTwo = PointOne; // So JAVA Creates a NEW POINTER location PointTwo.
                                    // That MEANs they PointOne and PointTwo point to the SAME memory box SAME VALUE The value of n.
        System.out.println("(FROM PointTwo)The value of x: " + PointTwo.x);
        PointTwo.x = 5;
        System.out.println("(When PointTwo.x = 5; is SET ) The value of x: " + PointOne.x);
        System.out.println("First x = 5; Then y = x + 2; Then x = 2; But y = :" + primitiveType());
        System.out.println("This Is The Difference Between Primitive and Reference Type");
    }
}