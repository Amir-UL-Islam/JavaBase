package com.aiokleo.problemSolving.groupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> groups = new HashMap<>();
//        for (String s : strs) {
//            char[] sArray = s.toCharArray();
//            Arrays.sort(sArray);
//            groups.put(String.valueOf(sArray), new ArrayList<>());
//        }
//        for (int i = 0; i < strs.length; i++) {
//            char[] sArray = strs[i].toCharArray();
//            Arrays.sort(sArray);
//            groups.get(String.valueOf(sArray)).add(strs[i]);
//        }
//
//        List<List<String>> groupAnagram = new ArrayList<>();
//        for (Map.Entry<String, List<String>> group : groups.entrySet()) {
//            groupAnagram.add(group.getValue());
//
//        }
//        return groupAnagram;
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
