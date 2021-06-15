import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isCorrect("a+([{457}])"));
    }

    private static boolean isCorrect(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty()) {
                    char cc = stack.pop();
                    if ((c == ']' && cc != '[') || (c == '}' && cc != '{') || (c == ')' && cc != '(')) {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }
}
