package Strings.Day4RemoveDuplicates;

import java.util.*;

/**
 * See Leetcode Link: {@link https://leetcode.com/problems/remove-duplicate-letters/description/}
 */
class RemoveDuplicates {

    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicateLetters2(str));
    }

    private static String removeDuplicateLetters2(String str) {

        Map<Character, Integer> lastMap = new HashMap<>();

        for (int i = str.length()-1 ; i>=0; i--) {
            if (!lastMap.containsKey(str.charAt(i))) {
                lastMap.put(str.charAt(i), 0);
            }

        }

        return "";
    }

    public static String removeDuplicateLetters(String s) {
        int stringLength = s.length();
        int[] lastIndex = new int[26]; // to store the last index of each character

        // Fill array with the last position of each character in the string
        for (int i = 0; i < stringLength; ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>(); // stack to hold the characters for result
        int bitmap = 0; // to keep track of which characters are already in stack

        // Iterate through the string characters
        for (int i = 0; i < stringLength; ++i) {
            char currentChar = s.charAt(i);
            // Check if the current character is already in stack (bit is set)
            if (((bitmap >> (currentChar - 'a')) & 1) == 1) {
                continue; // Skip if character is already present
            }

            // Ensure characters in stack are in the correct order and remove any that aren't
            while (!stack.isEmpty() && stack.peek() > currentChar && lastIndex[stack.peek() - 'a'] > i) {
                bitmap ^= 1 << (stack.pop() - 'a'); // Set the bit to 0 for popped character
            }

            stack.push(currentChar); // Add current character to the stack
            bitmap |= 1 << (currentChar - 'a'); // Set the bit to 1 for current character
        }

        StringBuilder resultBuilder = new StringBuilder();
        // Build the result string from the characters in stack
        for (char c : stack) {
            resultBuilder.append(c);
        }

        // The order of characters in stack is reversed, so we need to reverse the string
        return resultBuilder.reverse().toString();
    }
}