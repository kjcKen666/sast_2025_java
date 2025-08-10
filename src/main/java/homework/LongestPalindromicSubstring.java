package homework;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        // TODO begin

        // TODO end
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string:");
        String input = scanner.nextLine();
        String result = longestPalindrome(input);
        System.out.println("The longest palindromic substring is: " + result);
    }
}
