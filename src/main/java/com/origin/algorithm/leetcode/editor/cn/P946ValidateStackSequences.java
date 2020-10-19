/*
[946]验证栈序列
validate-stack-sequences
//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class P946ValidateStackSequences {
    public static void main(String[] args) {
        //Solution solution = new P946ValidateStackSequences().new Solution();
    }

    /**
     * 思路：
     * 模拟栈的push和pop过程
     * 构建一个空栈，判断栈顶元素是否是popped数组中第一个元素
     * 若是，则出栈，同时popped数组指针指向下一个元素
     * 若不是，则将pushed数组一个元素入栈
     * 当且仅当两个数组都到末尾才算匹配
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int push = 0;
        int pop = 0;

        while (push < pushed.length && pop < popped.length) {

            while (stack.isEmpty() || stack.peek() != popped[pop]) {
                stack.push(pushed[push]);
                push++;
                if (push == pushed.length) {
                    break;
                }
            }
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
                if (pop == popped.length) {
                    break;
                }
            }
        }

        return push == pushed.length && pop == popped.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}