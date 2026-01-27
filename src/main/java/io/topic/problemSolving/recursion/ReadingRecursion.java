public class ReadingRecursion{
    public static void main(String[] args){
        System.out.println(factorialTopDown(5));
        System.out.println(factorialBottomTop(5, 1, 1));
        System.out.println(factorialLoopBottomTop(5));
        System.out.println(factorialLoopTopBottom(5));

    }

    public static int factorialTopDown(int number){
        if (number == 1) {
            return 1;
        } else {  
            return number * factorialTopDown(number - 1);
        }
    }

    public static int factorialBottomTop(int number, int i , int product){
        if (i > number){
            return product;
        }else{
            return factorialBottomTop(number, i + 1, product * i);
        }
    }

    public static int factorialLoopBottomTop(int number){
        int product = 1;
        for(int i = 1; i <= number; i ++){
            product *= i;
        }
        return product;
    }

    public static int factorialLoopTopBottom(int number){
        int product = 1;
        for(int i = number; i == 1; i --){
            product *= i;
        }
        return product;
    }
}
