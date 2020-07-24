/*
[516]最长回文子序列
longest-palindromic-subsequence
//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //Solution solution = new P516LongestPalindromicSubsequence().new Solution();
    }

    /**
     * 思路：
     * 若区间[a,b]的回文子序列长度为f(a,b);
     * 若ab相等，则f(a,b) = f(a+1,b-1) + 2
     * 若ab不等，则f(a,b) = max(f(a+1,b),f(a,b-1)
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[][] dp = new int[s.length()][s.length()];

        dp[0][0] = 1;

        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    dp[j][i] = dp[j+1][i-1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                }
            }
        }

        return dp[0][s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}