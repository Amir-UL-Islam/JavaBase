//public class Solution {
//    public static void main(String[] args) {
//        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
//        int k = 3;
//        Solution.rotate(nums, k);
//        for (int i : nums) {
//            System.out.println(i);
//        }
//
//    }
//
//    public static void rotate(int[] nums, int k) {
//
//        for (int i = 0; i < k; i++) {
//            int lastValue = nums[nums.length - 1];
//            for (int j = nums.length - 2; j >= 0; j--){
//                nums[j + 1] = nums[j];
//            }
//            nums[0] = lastValue;
//        }
//    }
//}
