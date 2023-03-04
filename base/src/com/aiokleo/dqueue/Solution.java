package com.aiokleo.dqueue;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nNumbers = scan.nextInt();
        int nNumberCombination = scan.nextInt();
        Set<Integer> set = new HashSet<>();
        Deque deque = new ArrayDeque<>();

        int maxNumberOfUnique = 0;
        for (int i = 0; i < nNumbers; i++) {
            int Numbers = scan.nextInt();
            deque.add(Numbers);
            set.add(Numbers); // Only Unique Entity will be Added in the Set
            if(deque.size() == nNumberCombination){
                if(set.size() > maxNumberOfUnique)
                    maxNumberOfUnique = set.size(); // Assigning New Maximum Unique Number

                // Cleaning up Dequeue
                int x = (int)deque.removeFirst();
                if(!deque.contains(x)){
                    set.remove(x);
                }
            }
        }
        System.out.println(maxNumberOfUnique);
    }
}
