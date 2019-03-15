package leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {
    public static void main(String args[]) {
        LongestSubString longestSubString = new LongestSubString();
        int longestSubStr = longestSubString.lengthOfLongestSubstring("abcabcbb");
        System.out.print(longestSubStr);
    }

    public int lengthOfLongestSubstring(String s) {


        return 0;
    }
}
