import java.util.Stack;

public class BalanceBrackets {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        // Convert the input string to a character array
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket: push onto the stack
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // Closing bracket: check if it matches the top of the stack
                if (stack.isEmpty()) {
                    return false; // Unbalanced
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // Unbalanced
                }
            }
        }

        // If the stack is empty, the string is balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "({[a+b]+c}-1)";
        boolean result = isBalanced(input);
        System.out.println("Is the input string balanced? " + result);
    }
}
