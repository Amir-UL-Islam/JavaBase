package com.aiokleo.BigDecimal;
import java.math.BigDecimal;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<BigDecimal> s = new ArrayList<>();
        for (int i = 0; i < n; i ++ ){
        BigDecimal totalQuantity = new BigDecimal(sc.next());
            s.add(totalQuantity);
        }
        sc.close();
        s.sort((a, b) -> b.compareTo(a));
        for (BigDecimal i : s) {
            System.out.println(i);
        }

    }
}
