package com.aiokleo.problemSolving.palindrome;

public class IsPalindrome {
//        SolutionTowPointerApproach solutionTowPointerApproach = new SolutionTowPointerApproach();
//        SolutionBrutForceApproach solutionBrutForceApproach = new SolutionBrutForceApproach();
//        System.out.println(solutionTowPointerApproach.isPalindrome("talat"));
//        System.out.println(solutionBrutForceApproach.isPalindrome("talat"));

    //    //     Brut-Force Approach
    public boolean isPalindromeII(String s) {
        String reversedString = "";
        char ch;
        String new_s = s.replaceAll("[^a-zA-Z\\d:\\u00C0-\\u00FF]", "").trim().replace(":", "").toLowerCase();
        for (int i = 0; i < new_s.length(); i++) {
            ch = new_s.charAt(i);
            reversedString = ch + reversedString;
        }
        if (reversedString.equals(new_s)) {
            return true;
        }
        return false;

    }


    //Tow-Pointer Approach
//The advantage is the space complexity is O(1) the constant
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true; // An empty string or null is considered a palindrome
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

//                This is String "23erewr342"
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

}
