package com.aiokleo.problemSolving.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    // Pseudocode framework of sliding window algorithm
void slidingWindow(String s) {
    // Use an appropriate data structure to record the data in the
    // window, which can vary according to the specific scenario
    // For example, if I want to record the frequency
    // of elements in the window, I would use a map
    // If I want to record the sum of elements in the window, I could just use an int
    List<Object> window = new ArrayList<>();
    char[] sArr = s.toCharArray();

    
    int left = 0, right = 0;
    while (right < s.length()) {
        // c is the character that will be added to the window
        char c = sArr[right];
        window.add(c);
        // Expand the window
        right++;
        // Perform a series of updates to the data within the window


        // *** Position of debug output ***
        // Note that in the final solution code, do not use print
        // Because IO operations are time-consuming and may cause timeouts
        System.out.println("window: ["+ left + ","+ right + "]");
        // ***********************

        // Determine whether the left side of the window needs to shrink
//        while (left < right && window needs shrink) {
//            // d is the character that will be removed from the window
//            char d = s[left];
//            window.remove(d)
//            // shrink the window
//            left++;
//            // perform a series of updates to the data within the window
//            ...
//        }
    }
}
}
