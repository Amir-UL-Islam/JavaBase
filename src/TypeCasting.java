public class TypeCasting {

    static int ReferenceTypeCasting(){
        String S = new String("55");
        return Integer.parseInt(S); // Converting a String to Int
    }
    public static void main(String[] args){
//        Implicit Casting/ Automatic Casting
//        Byte>Short>Integer>Long > float >
        byte B = 4;
        double D = B + 2.3; // Here B is automatically Caste to Double
        int I = B + 4;
        long L = I + 430000000000000000L;
//        int N = 4L;
// java: incompatible types: possible lossy conversion from long to int
//        System.out.println(N);
        System.out.println(L);
//        Explicit Casting
        int X = B + (int)2.3; // Here 2.3 is automatically Caste to 2 (int)
        System.out.println(X);

        // STRING to INTEGER
        System.out.println(ReferenceTypeCasting());

    }
}
