package com.aiokleo.problemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KTopMostFrequent {
    public static void main(String args[]){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));

    }
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> ks = new HashMap<>();

        for (int i: nums){
            ks.put(i, ks.getOrDefault(i, 0)+1);
        }

        for (int key : ks.keySet()) {
            int freq = ks.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;

    }
}
