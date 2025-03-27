package com.aiokleo.problemSolving.threeSum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

    }

    static List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<List<Integer>>> groups = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    for (int k = 0; k < nums.length; k++) {
                        if (k != j && k != i) {
                            if (nums[k] + nums[j] + nums[i] == 0) {
                                int[] s = new int[] { nums[i], nums[j], nums[k] };
                                Arrays.sort(s);
                                String key = Arrays.toString(s);
                                groups.computeIfAbsent(key, f -> new ArrayList<>())
                                        .add(Arrays.asList(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }

        }
        return groups.keySet()
                .stream()
                .map(it -> it.substring(1, it.length() - 1).split(","))
                .map(it -> Arrays.stream(it).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    static List<List<Integer>> threeSumII(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    for (int k = 0; k < nums.length; k++) {
                        if (k != j && k != i) {
                            if (nums[k] + nums[j] + nums[i] == 0) {
                                List<Integer> s = Arrays.asList(nums[i], nums[j], nums[k]);
                                Collections.sort(s);
                                if (!result.contains(s)) {
                                    result.add(s);
                                }
                            }
                        }
                    }
                }

            }
        }
        return result;
    }

    public List<List<Integer>> threeSumIII(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        answer.add(list);
                    }
                }
            }
        }
        return answer;
    }

    public List<List<Integer>> threeSumIV(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
