import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWord {
    public static void main(String[] args) {

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        ArrayList<String> matchedGroup = new ArrayList<String>();
        ArrayList<String> matchedGroup1 = new ArrayList<String>();

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = pattern.matcher(input);

//             Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
                matchedGroup.add(m.group());
            matchedGroup1.add(m.group(1));
            }
            System.out.println(matchedGroup);

            // Prints the modified sentence.
//            System.out.println(input);
            System.out.println("Break");
            System.out.println(matchedGroup1);
        }

        in.close();
    }
}