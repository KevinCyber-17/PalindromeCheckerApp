import java.util.*;

public class PalindromeCheckerApp {

    // Algorithm 1: Reverse String Method
    public static boolean reverseMethod(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();

        return normalized.equals(reversed);
    }

    // Algorithm 2: Two Pointer Method
    public static boolean twoPointerMethod(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Algorithm 3: Stack Method
    public static boolean stackMethod(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Reverse Method timing
        long start1 = System.nanoTime();
        boolean r1 = reverseMethod(input);
        long end1 = System.nanoTime();

        // Two Pointer timing
        long start2 = System.nanoTime();
        boolean r2 = twoPointerMethod(input);
        long end2 = System.nanoTime();

        // Stack Method timing
        long start3 = System.nanoTime();
        boolean r3 = stackMethod(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Reverse Method: " + r1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Two Pointer Method: " + r2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Stack Method: " + r3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}