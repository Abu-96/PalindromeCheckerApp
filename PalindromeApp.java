public class PalindromeApp {

    public static void main(String[] args) {

        // Input string
        String input = "Level";

        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        // Context using selected strategy
        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeCheck(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        // Normalize to ignore case
        input = input.toLowerCase();

        // Create a stack to store characters
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push each character onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.check(input);
    }
}