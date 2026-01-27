import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenizers {
    public static void main(String[] args) throws Exception{
        System.out.println("Enter the Number: ");

        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader BR = new BufferedReader(ISR);



        StringTokenizer ST = new StringTokenizer(BR.readLine().trim());
        while(ST.hasMoreTokens()){

            System.out.println(ST.nextToken());
        }

    }
}






















