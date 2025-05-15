public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        Solution.rotateI(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }

    }

    public static void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int lastValue = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = lastValue;
        }
    }

    public static void rotateI(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] k_first_temp = new int[k];

        for (int i = 0; i < k; i++) {
            k_first_temp[i] = nums[i];
        }

        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        for (int i = n - k; i < n; i++) {
            nums[i] = k_first_temp[i - (n - k)];

        }

    }

    public void rotateII(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
