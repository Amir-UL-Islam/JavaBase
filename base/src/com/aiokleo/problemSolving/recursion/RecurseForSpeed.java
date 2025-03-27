public class RecurseForSpeed {

    public static void main(String[] args) {
        int[] array = new int[] { 0, 5, 2, 1, 6, 3 };
        int length = array.length;
        int left = 0;
        int right = length - 1;
        sort(array, left, right);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void sort(int[] array, int left, int right) {
        if (left - right <= 0)
            return;
        int pivot_index = partition(left, right, array);
        sort(array, left, pivot_index - 1);
        sort(array, pivot_index + 1, right);

    }

    public static int partition(int left, int right, int[] array) {
        int swap;
        int pivot = array[right];
        right -= 1;

        while (left <= right) {
            if (array[left] < pivot) {
                left++;
                // The left pointer continuously moves one cell to the right
                // until it reaches a value that is greater than or equal to the pivot
                // , and then stops.
            } else if (array[right] > pivot) {
                right--;
                // The right pointer continuously moves one cell to the left
                // until it reaches a value that is less than or equal to the pivot
                // , and then stops.
                // The right pointer will also stop
                // if it reaches the beginning of the array.
            } else {
                swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                // Finally, we swap the pivot with the value that the left pointer
                // is currently pointing to
                left++;
            }

        }
        array[left] = pivot;
        return left;

    }

}
