import java.util.Arrays;

public class RotateWithDirection {
//int[] arr = {1, 2, 3, 4, 5};

    public static int[] rotateArray(int[] arr, int k, String direction) {
        int n = arr.length;
        k = k % n; // Effective rotations

        if (direction.equalsIgnoreCase("right")) {
            // Right rotation
            return concatenate(Arrays.copyOfRange(arr, n - k, n), Arrays.copyOfRange(arr, 0, n - k));
        } else if (direction.equalsIgnoreCase("left")) {
            // Left rotation
            return concatenate(Arrays.copyOfRange(arr, k, n), Arrays.copyOfRange(arr, 0, k));
        } else {
            throw new IllegalArgumentException("Invalid direction. Use 'right' or 'left'.");
        }
    }

    // Helper method to concatenate two arrays
    private static int[] concatenate(int[] part1, int[] part2) {
        int[] result = new int[part1.length + part2.length];
        System.arraycopy(part1, 0, result, 0, part1.length);
        System.arraycopy(part2, 0, result, part1.length, part2.length);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Example usage
        int[] rightRotated = rotateArray(arr, 2, "right");
        System.out.println("Right Rotated: " + Arrays.toString(rightRotated)); // Output: [4, 5, 1, 2, 3]

        int[] leftRotated = rotateArray(arr, 2, "left");
        System.out.println("Left Rotated: " + Arrays.toString(leftRotated));  // Output: [3, 4, 5, 1, 2]
    }
}

