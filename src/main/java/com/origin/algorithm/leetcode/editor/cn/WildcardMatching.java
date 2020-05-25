/*
[44]通配符匹配
wildcard-matching
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输入: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
    }

    /**
     * 大致思路：
     * 进行逐字符的匹配
     * ？匹配任意一个字符
     * * 匹配0～n个字符
     * 其他字符匹配相等的字符
     *
     * 对于*，可以匹配若干个字符，因此会有n种可能性
     * 需要每个对每个可能性进行匹配
     *
     * 为理解上直观，采取递归的方式
     * 若s与p的第一个字符匹配，则进行字串的匹配
     *
     * 递归解法超时
     * 优化点：缓存已有的结果 避免重复计算
     *
     * 假设匹配结果为result
     * 1。非*的情况
     * result[0,0] = isCharMatch(0,0) & isMatch(1,1);
     * result[x, y] = isCharMatch(x,y) & isMatch(x+1, y+1);
     * x<=s.length-1 y<=p.length-1
     * 2。*的情况
     * result[0,0] = （isMatch(0,1) | isMatch(1,1) |··· isMatch(s.length, 1);
     * result[x,y] = （isMatch(x,y+1) | isMatch(x+1,y+1) |··· isMatch(s.length, y+1);
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        return isMath(s, 0, p, 0);
    }


    private boolean isMath(String s, int sIndex, String p, int pIndex) {
        //假设p是空字符串 则s必须是空字符串才算匹配
        if (pIndex >= p.length()) {
            if (sIndex >= s.length()) {
                return true;
            } else {
                return false;
            }
        }
        //p不是空字符串
        char pChar = p.charAt(pIndex);
        //*的情况
        if (pChar == '*') {
            //*可以匹配0到n个字符 只有有一个成功就算成功
            //计算s还剩多少字符
            int remain = s.length() - sIndex;
            //匹配i个字符的情况
            for (int i = 0; i <= remain; i++) {
                if (isMath(s, sIndex + i, p, pIndex + 1)) {
                    return true;
                }
            }
            return false;
        }
        //非* 并且s是空字串
        if (sIndex >= s.length()) {
            return false;
        }
        //?直接匹配单个字符 因此直接匹配下一个字串
        if (pChar == '?') {
            //匹配下一个字符
            return isMath(s, sIndex + 1, p, pIndex + 1);
        }
        if (pChar == s.charAt(sIndex)) {
            //匹配成功 匹配下一个字串
            return isMath(s, sIndex + 1, p, pIndex + 1);
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}