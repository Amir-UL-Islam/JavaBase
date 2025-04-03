package com.aiokleo.setHashset;
import java.util.*;

public class Hashset {
//    A Set is a generic set of values with no duplicate elements.

//    A TreeSet is a set where the elements are sorted.

//    A HashSet is a set where the elements are not sorted or ordered.
//    It is faster than a TreeSet. The HashSet is an implementation of a Set.

   public static void main(String args[]) {
      int a[] = {77, 23, 4, 66, 99, 112, 45, 56, 39, 89};
      Set<Integer> s = new HashSet<Integer>();
      try {
         for(int i = 0; i < 5; i++) {
            s.add(a[i]);
         }
         System.out.println(s);

         TreeSet sorted = new TreeSet<Integer>(s);
         System.out.println("Sorted list: " + sorted);
      }
      catch(Exception e) {}
   }
}
