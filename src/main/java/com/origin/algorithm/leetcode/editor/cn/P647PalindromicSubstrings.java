/*
[647]回文子串
palindromic-substrings
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P647PalindromicSubstrings {
    public static void main(String[] args) {
        //Solution solution = new P647PalindromicSubstrings().new Solution();
    }

    /**
     * 思路：
     * 要统计所有回文字串个数，就得遍历所有的字串
     * 要判断所有的区间是否是回文，假设f(a,b)
     * 则f(a,b) = (a==b) && f(a+1,b-1)
     *
     * TODO 马拉车解法 中心扩展解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int sum = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            sum++;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i > 2) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}