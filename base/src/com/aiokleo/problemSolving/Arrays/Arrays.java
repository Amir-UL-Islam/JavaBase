public class Arrays {
    // Function to implement
    // search operation
    static int findElement(int arr[], int n, int value) {
        for (int i = 0; i < n; i++)
            if (arr[i] == value)
                return i;

        // If the key is not found
        return -1;
    }

    static int insertSorted(int arr[], int position, int key, int capacity) {

        // Cannot insert more elements if n
        // is already more than or equal to
        // capacity
        if (position >= capacity)
            return position;

        arr[position] = key;

        return (position + 1);
    }

    // Driver's Code
    public static void main(String args[]) {
        int arr[] = new int[20];

        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 90;

        int n = arr.length;

        // Using a last element as search element
        int value = 40;

        // Function call
        int position = findElement(arr, n, value);

        if (position == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element " + value + " Found at Position: "
                    + (position + 1));

        int valueToBeInsert = 70;

        // Insertion
        System.out.print("Before Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        int capacity = arr.length; // Usually that the case

        // Inserting key
        n = insertSorted(arr, 6, valueToBeInsert, capacity);

        System.out.print("\n After Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
