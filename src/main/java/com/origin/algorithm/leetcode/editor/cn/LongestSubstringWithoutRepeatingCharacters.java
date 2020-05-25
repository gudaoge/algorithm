/*
[3]无重复字符的最长子串
longest-substring-without-repeating-characters
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abba");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双指针解法：
     * 左指针遍历一次，右指针遍历一次 时间复杂度O（n）
     */
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        //用双指针a,b划分子串
        //假设s[a]...s[b]为无重复子串
        //s[a]...s[b]s[b+1]为有重复子串
        //若重复字符位置为x
        //则下一个无重复字串为s[x+1]...s[b+1]，当前最大无重复子串长度为b-a+1
        //ab指针若越界，则结束
        int a = 0, b = 0;
        char[] arr = s.toCharArray();
        //首先保存当前子串的所有字符
        Set<Character> set = new HashSet<>();
        //记录当前无重复字串长度
        int max = 0;
        while (a < arr.length && b < arr.length) {
            if (!set.contains(arr[b])) {
                //不包含重复字符 右指针右移
                set.add(arr[b]);
                b++;
            } else {
                //包含重复字符
                // 更新最大重复字串长度
                if (b - a > max) {
                    max = b - a;
                }
                // 左指针右移
                set.remove(arr[a]);
                a++;
            }
        }
        //指针越界了 再判断最后一个字串的长度
        if (b - a > max) {
            max = b - a;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}