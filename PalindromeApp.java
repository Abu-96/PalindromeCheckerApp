public class PalindromeApp {
    public static void main(String[] args) {

        // Define input string
        String input = "madam";

        // Call recursive method
        boolean isPalindrome = check(input, 0, input.length() - 1);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
    private static boolean check(String s, int start, int end) {

        // Base condition: if start index crosses end index
        if (start >= end) {
            return true;
        }

        // If characters at current positions do not match
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call moving toward center
        return check(s, start + 1, end - 1);
    }
}