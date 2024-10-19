package Strings.Day1ReverseString;

/**
 * See Leetcode Link: {@link https://leetcode.com/problems/reverse-string/}
 */
class ReverseString {

    public static void main(String[] args) {
        String str = "codewithprakhar";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            swap(charArray, start, end);
            start++;
            end--;
        }
        return new String(charArray);
    }

    public static void swap(char[] charArray, int start, int end) {
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
    }
}
