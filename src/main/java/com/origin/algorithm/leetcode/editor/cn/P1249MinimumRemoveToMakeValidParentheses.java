/*
[1249]移除无效的括号
minimum-remove-to-make-valid-parentheses
//给你一个由 '('、')' 和小写字母组成的字符串 s。 
//
// 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。 
//
// 请返回任意一个合法字符串。 
//
// 有效「括号字符串」应当符合以下 任意一条 要求： 
//
// 
// 空字符串或只包含小写字母的字符串 
// 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」 
// 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "lee(t(c)o)de)"
//输出："lee(t(c)o)de"
//解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
// 
//
// 示例 2： 
//
// 输入：s = "a)b(c)d"
//输出："ab(c)d"
// 
//
// 示例 3： 
//
// 输入：s = "))(("
//输出：""
//解释：空字符串也是有效的
// 
//
// 示例 4： 
//
// 输入：s = "(a(b(c)d)"
//输出："a(b(c)d)"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s[i] 可能是 '('、')' 或英文小写字母 
// 
// Related Topics 栈 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class P1249MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        //Solution solution = new P1249MinimumRemoveToMakeValidParentheses().new Solution();
    }

    /**
     * 思路：
     * 其实就是括号匹配
     * 对于每个），在他之前必须有（与之匹配，若匹配，则）输出，若无（匹配，则删除）
     * 最终，对于没有匹配的（，都要进行删除
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stringBuilder.append(c);
                stack.push(stringBuilder.length() - 1);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    stringBuilder.append(c);
                }
            } else {
                stringBuilder.append(c);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.deleteCharAt(stack.pop());
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}