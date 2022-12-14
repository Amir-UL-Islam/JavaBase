package throwNewException;
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
class MyCalculate{
    public long power(int x, int y) throws Exception {
        if (x == 0) {
            if (y == 0) {
                throw new Exception("n and p should not be zero.");
            }
        } else if (x < 0 || y < 0) {
            throw new Exception("n or p should not be negative.");
        } else {
            return (long)Math.pow(x, y);
        }
        return 0;
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        MyCalculate power = new MyCalculate();
        while(scan.hasNext()){
            StringTokenizer st = new StringTokenizer(scan.nextLine().trim());
            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                try{
                    System.out.println(power.power(n, p));
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}