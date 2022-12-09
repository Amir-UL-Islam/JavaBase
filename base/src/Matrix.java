import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args){
        int[][] Matrix = new int[3][2];
        Matrix[0][0] = 10;
        Matrix[2][1] = 10;

        System.out.println(Arrays.deepToString(Matrix));;

//        Second Way
        int[][][] Matrix3D = {
                                {{1, 1}, {2, 2}},
                                {{3, 3}, {4, 4}},
                                {{5, 5}, {6, 6}}
                                                };
        System.out.println(Arrays.deepToString(Matrix3D));


    }
}
