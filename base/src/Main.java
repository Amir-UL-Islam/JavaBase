//JDK is for development purpose whereas JRE is for running the java programs.
//JDK and JRE both contains JVM so that we can run our java program.
//JVM is the heart of java programming language and provides platform independence.


// The Main Class
// with public access modifier
public class Main {
//     main is a Method
    public static void main(String[] args) {  // void is for not returning anything.
        byte age = 22; // byte data type take -128 to 128 which is enough for age Variable
        long EarthAge = 4_543_000_000L; // Here adding suffix L for telling the compiler that it's a long number.
        float EarthAgeInBillion = 4.543F; // Float is of size 32 bits while double is of size 64 bits.
        char CountryNameStartWith = 'B';
        String CountryName = "Bangladesh";
        boolean IsACitizen = true;

//        Printing Out Values
        System.out.println(age);
        System.out.println(EarthAge);
        System.out.println(EarthAgeInBillion);
        System.out.println(CountryNameStartWith);
        System.out.println(CountryName);

//        Condition
        if (IsACitizen == true){
            System.out.println("TRUE");
        }




    }
}