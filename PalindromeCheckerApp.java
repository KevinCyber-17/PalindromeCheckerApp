import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize string:
        // 1. Remove all spaces using regular expression
        // 2. Convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("The given string is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}