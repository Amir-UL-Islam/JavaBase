import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Compare compare = new Compare();
        System.out.println(compare.Check(stack));

    }
}

class Compare {
    static boolean OpenClose(String open, String close) {
        if (open.equals("(") && close.equals(")"))
            return true;

        if (open.equals("{") && close.equals("}"))
            return true;

        if (open.equals("[") && close.equals("]"))
            return true;

        return false;
    }

    public boolean Check(Stack<String> stack) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split("");
            for (String token : tokens) {
                if (token.equals("(") || token.equals("{") || token.equals("[")) {
                    // if Bracket is Open it is Stored in Stack
                    stack.push(token);

                    // if Find a Closing Bracket -> Try to Match Them/It to previously Opened One.
                } else{  

                    if (token.equals(")") || token.equals("}") || token.equals("]")) {

                        // if the Stack Still Empty. No Opening Bracket Not Stored Yet. And only a Closing Bracket Appeared .
                        // Then there is No chance to find valid One.
                        if (stack.isEmpty()) {
                            return false;
                        }
        //                    Remember Stack = Last in Fast Out.
                        // So, Try of Match Last Opened Bracket
                        // As Stack is not Empty and Closing Bracket is Found . Try to Match them.
                        String firstOpenedBracket = stack.pop(); // Popping the Last Opened Bracket. And Passing it As an open Parameter
                        // Where last Found token is the Close parameter
                        if (!OpenClose(firstOpenedBracket, token)) {
                            return false;
                        }
                    }
                }
            }
        }
        scan.close();
        return true;
    }
}
