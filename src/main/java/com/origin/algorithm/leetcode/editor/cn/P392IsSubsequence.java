/*
[392]判断子序列
is-subsequence
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P392IsSubsequence {
    public static void main(String[] args) {
        //Solution solution = new P392IsSubsequence().new Solution();
    }

    /**
     * 思路：
     * 双指针
     * 每次取出s中的一个字符，判断它在t中的位置
     * 若找到则双指针后移
     * 若未找到则返回false
     *
     * 缺点：需要遍历s和t，时间复杂度O(s+t)
     *
     * 若有多个s需要判断，则每次计算都是相互独立的，无法利用之前的结果
     * 参考题解可知，可以对t进行预处理
     * 由于每次都是从t中找出第一个匹配的字符，因此可以记录t中每个字符后面的a-z每个字符第一个的位置
     * 这样每次判断s的时候，只需要进行s.length次查找
     * 而预处理的过程可以采用dp
     *
     * TODO dp版后续实现
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        return twoPoint(s, t);
    }

    private boolean twoPoint(String s, String t) {
        int left = 0;
        int right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left == s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}