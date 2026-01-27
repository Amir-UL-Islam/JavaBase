import java.util.Random;

public class RandomNumber {
    public static void main(String[] args){
        // Setting the SEED 100
        Random randomOne = new Random();

        randomOne.setSeed(100);
        System.out.println(randomOne.nextInt());
        
        // Setting the SEED 100
        Random randomTwo = new Random();

        randomTwo.setSeed(100);
        System.out.println(randomTwo.nextInt());
    }
}
