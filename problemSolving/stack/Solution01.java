import java.util.*;

public class Solution01 {
    public static void main(String[] args) {
        Compare compare = new Compare();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        System.out.println(compare.check(sc.next()));
        }
        sc.close();
    }
    
}

class Compare {
    static boolean openClose(char open, char close) {
        if (open == '(' && close == ')')
            return true;
        if (open == '{' && close == '}')
            return true;
        if (open == '[' && close == ']')
            return true;
        return false;
    }

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpened = stack.pop();
                if (!openClose(lastOpened, c)) {
                    return false;
                    }
                }
            }
        return stack.isEmpty();
    }
}
