public class CountDown{
    public static void main(String[] args){
        countdown(5);
    }

    public static void countdown(int number){
        if (number != 0){
            System.out.println(number);
            countdown(number - 1);
        } else System.out.println(0);
    }
}
