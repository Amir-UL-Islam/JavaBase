public class Operators {
    int a;
    int b;

    static double floatDivision(){
       double x = 10;
       double y = 3;
       double result = x / y;
       return result;
    }

    public int beforeIncrement(){
        int a = 1;
        int b = ++a;
        return  b;
    }
    public int afterIncrement(){
        int a = 1;
        int b = a++;
        return b;
    }
    static int orderOfOperations(){
        return 10 + 3 * 2; // This will return 16. If I want 26 I need to add () LIKE (10 + 3) * 2
    }

    public static void main(String[] args){

        Operators Division = new Operators();
        Division.a = 5;
        Division.b = 2;

//        Dy default JAVA done Integer Division
        int result = Division.a/Division.b;
        System.out.println("Result of Integer Division of  and is : " + result);
//        If We want to return FLOATING POINT We HAVE To CAST DATA TYPE as FLOAT or double
//        double result =  (double) 10 / (double) 3;
        System.out.println("Result of Normal Division of 10 and 3 is : " + floatDivision());
        Operators InterestingFacts = new Operators();
        System.out.println("Value of b when a = 1 and b = ++a: " + InterestingFacts.beforeIncrement());
        System.out.println("Value of b when a = 1 and b = a++: " + InterestingFacts.afterIncrement());
        System.out.println("(10 + 3 * 2); This will return 16. If I want 26 I need to add () LIKE (10 + 3) * 2;)");

    }

}
