package homework;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        // TODO begin
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // 奇数长度
            int len2 = expandAroundCenter(s, i, i + 1); // 偶数长度
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
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
