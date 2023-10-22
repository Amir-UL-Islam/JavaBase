//Library
//import java.unit.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Regex{
    public static void main(String[] args){
        Pattern p = Pattern.compile(".s");
        Matcher m = p.matcher("As");
        boolean result = m.matches();
        System.out.println(result);

    }
}
