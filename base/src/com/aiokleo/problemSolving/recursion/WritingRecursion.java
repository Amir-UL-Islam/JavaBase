public class WritingRecursion {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3 };
        System.out.println(sum(array, 0, 0));
        System.out.println(sumII(array, 0));
        System.out.println(sumIII(array));
        System.out.println(reverse("amir"));
        System.out.println(countingX("amir"));
    }

    public static int sum(int[] array, int index, int sum) {
        if (index > array.length - 1) {
            return sum;
        } else {
            sum += array[index];
            return sum(array, index + 1, sum);
        }
    }

    public static int sumII(int[] array, int index) {
        if (index > array.length - 1) {
            return 0;
        } else
            return array[index] + sumII(array, index + 1);
    }

    public static int sumIII(int[] array) {
        if (array.length == 1)
            return array[0];
        return array[0] + sumIII(subArray(array, 1, array.length - 1));
    }

    // Utility function to get a sub-array from array
    private static int[] subArray(int[] array, int start, int end) {
        int[] sub = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            sub[i - start] = array[i];
        }
        return sub;
    }

    // Utility function to get a sub-array from array
    private static String subArrayChar(char[] array, int start, int end) {
        char[] sub = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            sub[i - start] = array[i];
        }
        String subString = "";
        for (char c : sub) {
            subString += c;
        }
        return subString;
    }

    public static String reverse(String str) {
        if (str.length() == 1)
            return String.valueOf(str.toCharArray()[0]);
        return reverse(subArrayChar(str.toCharArray(), 1, str.length() - 1)) + str.toCharArray()[0];
    }

    public static int countingX(String string) {
        if (string.length() == 0)
            return 0;
        if (string.toCharArray()[0] == 'x') {
            return 1 + countingX(subArrayChar(string.toCharArray(), 1, string.length() - 1));
        } else
            return countingX(subArrayChar(string.toCharArray(), 1, string.length() - 1));
    }
}
