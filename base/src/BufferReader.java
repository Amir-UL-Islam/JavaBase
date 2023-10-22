import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BufferReader{
    
    public static void main(String[] args) throws Exception{
    System.out.println("Your Input as String Format: ");

    // Reading the Input as Buffer
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    // Converting the String to Integer
    int N = Integer.parseInt(br.readLine());
    System.out.println(N);


    }
}

