public class MathLib {

    public static void main(String[] args){
        int round = Math.round(1.1F);
        System.out.println("Round of 1.1F: " + round);

        int ceil = (int)Math.ceil(1.1F); // The Closest Next
        System.out.println("Ceil of 1.1F: " + ceil);

        int floor = (int)Math.floor(1.1F);
        System.out.println("Floor of 1.1F: " + floor);

        int max = Math.max(1, 2); // ALSO have min, round
        System.out.println("Max  1 and 2: " + max);


        // Returns a Floating Point Number
        double random = Math.random();
        System.out.println("Pure Random: " + random);

        double randomWith100 = random * 100;
        System.out.println("Random with * 100: " + randomWith100);

        // Casting without Brackets
        int randomWithoutBrackets = (int) random * 100;
        System.out.println("Explicitly CASTING Without Brackets: " + randomWithoutBrackets);

        // Math.round(Math.random()*100); This part of The CODE returns DOUBLE
        // So we Have to Store the RESULT in a DOUBLE Variable
        double randomDouble = Math.round(random * 100);
        System.out.println("With Round off: " + randomDouble);


        // or Cast It Explicitly
//        int randomInt = (int) Math.round( random * 100);
        int randomInt = (int) (random * 100);
        System.out.println("With round off and Explicitly Cast as Int: " + randomInt);

        System.out.println("2's power 2: " + Math.pow(2, 2));





    }
}
