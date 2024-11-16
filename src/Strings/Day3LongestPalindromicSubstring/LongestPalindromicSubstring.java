package Strings.Day3LongestPalindromicSubstring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * See Leetcode Link: {@link https://leetcode.com/problems/rotate-string/}
 */
class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    static String longestPalindrome(String s) {
        // Edge case: if the input string is empty, return an empty string
        if (s.isEmpty()) {
            return "";
        }

        int start = 0; // Start index of the longest palindrome
        int end = 0;   // End index of the longest palindrome

        // Loop through each character in the string to consider each as the center of a
        // potential palindrome
        for (int i = 0; i < s.length(); i++) {
            // Expand around the current character for odd-length palindromes
            int odd = expandAroundCenter(s, i, i);

            // Expand around the current character and the next character for
            // even-length palindromes
            int even = expandAroundCenter(s, i, i + 1);

            // Get the maximum length palindrome from both odd and even expansion
            int max_len = Math.max(odd, even);

            // If a longer palindrome is found, update the start and end indices
            if (max_len > end - start + 1) {
                start = i - (max_len - 1) / 2;
                end = i + max_len / 2;
            }
        }

        // Return the longest palindromic substring from the calculated start and end
        // indices
        return s.substring(start, end + 1);
    }

    // Helper function to expand the palindrome around a center (left, right) and return
    // the length
    private static int expandAroundCenter(String s, int left, int right) {
        // Expand outwards while the characters at both ends are equal and within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome found
        return right - left - 1;
    }
}