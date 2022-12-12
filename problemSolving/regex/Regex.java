import java.util.*;

public class Regex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creating a Object of Scanner Class
                                            // And passing System.in as parameter to 
                                            // Scanner Class
        //MyRegex pattern = new MyRegex();
        //System.out.println(input.matches(pattern.Pattern));    
        while (sc.hasNext()){
            String input = sc.nextLine();

            System.out.println(input.matches(new MyRegex().Pattern));    
            //sc.close();  
        }
    }
}
//     A static method in Java is a method that is part of a class rather than an instance of that class.
class MyRegex {
    // IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
    
//     The IP address must be in the form of string like A.B.C.D
//     The length of A, B, C, or D can't be greater than 3.
//     The value of A, B, C, and D should lie between 0 to 255. Following are the valid combinations of each number of an IP address.
//          Any one- or two-digit number.
//          Any 3-digit number beginning with 1.
//          Any 3-digit number beginning with 2 if the second digit is 0 through 4.
//          Any 3-digit number beginning with 25 if the third digit is 0 through 5.
    public static String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])"; 
//     - \d denotes the regular expression to represent number from o to 9.
//     - \\d{1, 2} represents any 1 or 2 digits number.
//     - (0|1)\\d{2} represents a three digit number which is starting from 0 or 1.
//     - 2[0-4]\\d represents numbers between 200 and 249.
//     - 25[0-5] represents number between 250 and 255.
//
    public static String Pattern = zeroTo255 + "\\."+ zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;  
    
}

