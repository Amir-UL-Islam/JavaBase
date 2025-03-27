//import java.util.HashSet;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("Amir", "mir"));
//        System.out.println(longestCommonSubsequenceII("Amir", "mir"));
//
//    }
//
//    public static int longestCommonSubsequence(String text1, String text2) {
//        String textOne = text1.length() > text2.length() ? text1 : text2;
//        String textTwo = text1.length() < text2.length() ? text1 : text2;
//
//        HashSet<String> commons = new HashSet<>();
//        int counter = 0;
//        for (String c : textOne.split("")) {
//            commons.add(c);
//        }
//        for (String c : textTwo.split("")) {
//            if (commons.contains(c)) {
//                counter++;
//            }
//        }
//        return counter;
//
//    }
//
//    private static String subArrayChar(char[] array, int start, int end) {
//        char[] sub = new char[end - start + 1];
//        for (int i = start; i <= end; i++) {
//            sub[i - start] = array[i];
//        }
//        String subString = "";
//        for (char c : sub) {
//            subString += c;
//        }
//        return subString;
//    }
//
//    public static int longestCommonSubsequenceII(String text1, String text2) {
//        HashSet<String> commons = new HashSet<>();
//        for (String c : text1.split("")) {
//            commons.add(c);
//        }
//        return countOf(text2, commons);
//
//    }
//
//    public static int countOf(String text2, HashSet<String> commons) {
//        if (text2.length() == 0) {
//            return 0;
//        } else if (commons.contains(text2.toCharArray()[0])) {
//            return 1 + countOf(subArrayChar(text2.toCharArray(), 1, text2.length() - 1), commons);
//        } else {
//            return countOf(subArrayChar(text2.toCharArray(), 1, text2.length() - 1), commons);
//        }
//    }
//
//    public static int countingX(String string) {
//        if (string.length() == 0)
//            return 0;
//        if (string.toCharArray()[0] == 'x') {
//            return 1 + countingX(subArrayChar(string.toCharArray(), 1, string.length() - 1));
//        } else {
//            return countingX(subArrayChar(string.toCharArray(), 1, string.length() - 1));
//        }
//    }
//}
