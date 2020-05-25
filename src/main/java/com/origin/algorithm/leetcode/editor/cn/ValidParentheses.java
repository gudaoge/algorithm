/*
[20]有效的括号
valid-parentheses
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    /**
     * 匹配原则
     * 即符号的开始必须匹配上符号的结束
     * 若符号匹配成功，则将符号删除，
     *
     * 因此，采用栈的形式，每次将栈顶元素与当前元素进行匹配，成功则出栈，失败则入栈
     * 若全部匹配成功，则栈应该为空
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character character : s.toCharArray()) {
            Character top = deque.peekLast();
            if (top == null) {
                deque.addLast(character);
                continue;
            }
            if (top == '(' && character == ')') {
                deque.pollLast();
                continue;
            }
            if (top == '[' && character == ']') {
                deque.pollLast();
                continue;
            }
            if (top == '{' && character == '}') {
                deque.pollLast();
                continue;
            }
            deque.addLast(character);
        }
        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}