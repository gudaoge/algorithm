/*
[28]实现 strStr()
implement-strstr
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

    /**
     * 暴力解法：
     * 从给定字符串的每个字符开始，逐个字符匹配
     * 需要两个指针
     * 一个指向haystack当前字符，一个指向needle当前字符
     * 当指针到末尾时，haystack指针移动到下一个字符，needle指针归0
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int a = 0;
        int b = 0;
        //假设
        while (a < (haystack.length() - needle.length() + 1)) {
            while (a+b < haystack.length() && b < needle.length()) {
                if (haystack.charAt(a + b) == needle.charAt(b)) {
                    //在未到字符串末尾时 指定位置的字符相等 则继续比较下一个字符
                    b ++;
                } else {
                    //未到字符串末尾时就有不同的字符，不符合条件
                    break;
                }
            }
            //到了某个字符串的末尾，并且之前的元素都相同
            //如果到了needle的末尾 说明找到了
            if (b == needle.length()) {
                return a;
            }
            //说明没找到 haystack指针移到下一个字符 needle归0
            a ++;
            b = 0;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}