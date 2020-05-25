/*
[150]逆波兰表达式求值
evaluate-reverse-polish-notation
//根据逆波兰表示法，求表达式的值。 
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: (4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
    }

    /**
     * 根据题目可以得知
     * 每次遇到计算符号时，取最近的两个数字计算结果并保存
     * 即构建一个栈
     * 遇到数字则入栈
     * 遇到计算符号出栈两次进行计算，将结果入栈
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                deque.addLast(deque.pollLast() + deque.pollLast());
                continue;
            }
            if ("-".equals(token)) {
                deque.addLast(- deque.pollLast() + deque.pollLast());
                continue;
            }
            if ("*".equals(token)) {
                deque.addLast(deque.pollLast() * deque.pollLast());
                continue;
            }
            if ("/".equals(token)) {
                Integer first = deque.pollLast();
                Integer second = deque.pollLast();
                deque.addLast(second / first);
                continue;
            }
            deque.addLast(Integer.parseInt(token));
        }

        return deque.peekLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}