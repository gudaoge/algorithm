/*
[1021]删除最外层的括号
remove-outermost-parentheses
//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
//，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
//
// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
//
// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
//
// 
//
// 示例 1： 
//
// 输入："(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 输入："(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 输入："()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 10000 
// S[i] 为 "(" 或 ")" 
// S 是一个有效括号字符串 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1021RemoveOutermostParentheses {
    public static void main(String[] args) {
        //Solution solution = new P1021RemoveOutermostParentheses().new Solution();
    }

    /**
     * 思路：
     * 题目的要求可以分为两步：
     * 1.拆分字符串
     * 2.去掉拆分后的子字符串的一层括号
     *
     * 那么我们先来拆分字符串
     * 对于每个（，都必须有对于的）与其匹配，
     * 那么我们可以采用栈来保存（，每遇到一个（就入栈，每遇到一个）就出栈
     * 当栈空时说明匹配到了一个子字符串
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String S) {

        int left = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (char s : S.toCharArray()) {
            if (s == '(')  {
                if (left > 0) {
                    stringBuilder.append(s);
                }
                left++;
            } else {
                left--;
                if (left > 0) {
                    stringBuilder.append(s);
                }
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}