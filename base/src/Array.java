import java.util.Arrays;
public class Array{
    public static void main(String[] args){
        int[] array = new int[5];
        array[0] = 10;
//        array[1] = "Ten";
        array[2] = 5;
//        array[3] = boolean;
//        array[10] = 20;
        System.out.println(Arrays.toString(array));
//        Length of the Array
        System.out.println("Length of the Array is: " + array.length);




//        Second Way
        int[] NewArray = {5, 3, 1, 4, 8};
        System.out.println("Unsorted " + Arrays.toString(NewArray));
        Arrays.sort(NewArray);
        System.out.println("Sorted Array " + Arrays.toString(NewArray));


    }

}
