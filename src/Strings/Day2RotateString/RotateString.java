package Strings.Day2RotateString;

/**
 * See Leetcode Link: {@link https://leetcode.com/problems/rotate-string/}
 */
class RotateString {

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";
        System.out.println(rotateString(str1, str2));
    }

    public static boolean rotateString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        else {
            for (int i = 0; i < s1.length(); i++) {
                // checking character at ith index with
                // first character of s2
                if (s1.charAt(i) == s2.charAt(0)) {
                    // checking prefix of s2 with suffix of
                    // s1
                    if (s1.substring(i).equals(s2.substring(
                            0, s1.length() - i))) {
                        // checking prefix of s1 with suffix
                        // of s2
                        if (s1.substring(0, i).equals(
                                s2.substring(s1.length()
                                        - i)))
                            return true;
                    }
                }
            }
        }
        return false;
    }
}