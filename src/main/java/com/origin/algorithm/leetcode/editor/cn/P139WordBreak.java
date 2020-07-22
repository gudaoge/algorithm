/*
[139]单词拆分
word-break
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.List;

public class P139WordBreak {
    public static void main(String[] args) {
        //Solution solution = new P139WordBreak().new Solution();
    }

    /**
     * 思路：
     * 假设长度为n的字符串的结果为f(n)
     * 则f(n) = f(n-x) && wordDict.contains(subString(x))
     * 即遍历wordDict每个元素x，当字符串s的末尾匹配x且f(n-x)为true时 f(n)为true
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i + 1 >= word.length()) {
                    dp[i + 1] |= dp[i + 1 - word.length()] && s.substring(i + 1 - word.length(), i + 1).equals(word);
                }
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}