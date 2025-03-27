public class Max {
    public static int max(int[] array) {
        // Base case - if the array has only one element, it is by definition the
        // greatest number:
        if (array.length == 1)
            return array[0];
        // Compare the first element with the greatest element from the remainder of the
        // array.
        // If the first element is greater, return it as the greatest number:
        if (array[0] > max(subArray(array, 1, array.length - 1)))
            return array[0];
        // Otherwise, return the greatest number from the remainder of the array:
        else
            return max(subArray(array, 1, array.length - 1));
    }

    // Utility function to get a sub-array from array
    private static int[] subArray(int[] array, int start, int end) {
        int[] sub = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            sub[i - start] = array[i];
        }
        return sub;
    }

    public static void main(String[] args) {
        int[] array = { 3, 7, 2, 8, 5 };
        System.out.println("Maximum element in the array: " + max(array));
    }
}
