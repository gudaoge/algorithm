/*
[1190]反转每对括号间的子串
reverse-substrings-between-each-pair-of-parentheses
//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1190ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        //Solution solution = new P1190ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    }

    /**
     * 思路：
     * 遍历字符串，每遇到一个），就将前面的最近的一个（之间的字符串反转
     * 可以用栈模拟，出）之外的所有字符入栈，遇到）后出栈直到（出栈，再将之间出栈的字符串入栈
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> temp = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop();
                while (!temp.isEmpty()) {
                    stack.push(temp.poll());
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}