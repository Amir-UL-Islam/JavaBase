public class DoublingArray{
    public static void main(String[] args){
        int[] array = new int[] {1, 2, 3};
        doubled(array, 0);
        for(int i = 0; i < array.length ; i ++){
            System.out.println(array[i]);
        }

    }

    public static void doubled(int[] array, int index){
        if(index >= array.length) return;
        array[index] *= 2;
        doubled(array, index + 1);
    }


}
