/*
[895]最大频率栈
maximum-frequency-stack
//实现 FreqStack，模拟类似栈的数据结构的操作的一个类。 
//
// FreqStack 有两个函数： 
//
// 
// push(int x)，将整数 x 推入栈中。 
// pop()，它移除并返回栈中出现最频繁的元素。
// 
// 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
// 
//
// 
//
// 示例： 
//
// 输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"
//],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
//
//pop() -> 返回 5，因为 5 是出现频率最高的。
//栈变成 [5,7,5,7,4]。
//
//pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
//栈变成 [5,7,5,4]。
//
//pop() -> 返回 5 。
//栈变成 [5,7,4]。
//
//pop() -> 返回 4 。
//栈变成 [5,7]。
// 
//
// 
//
// 提示： 
//
// 
// 对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。 
// 如果栈的元素数目为零，则保证不会调用 FreqStack.pop()。 
// 单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。 
// 单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。 
// 所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。 
// 
//
// 
// Related Topics 栈 哈希表

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P895MaximumFrequencyStack {
    public static void main(String[] args) {
        //Solution solution = new P895MaximumFrequencyStack().new Solution();
    }

    /**
     * 思路：
     * 首先，我们需要知道每个元素出现的次数
     * 其次，我们需要知道当前出现最多的元素的数量
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class FreqStack {

    Map<Integer, Stack<Integer>> freqGroup = new HashMap<>();
    Map<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {

    }
    
    public void push(int x) {
        int curFreq = freq.getOrDefault(x, 0) + 1;
        freq.put(x, curFreq);
        maxFreq = Math.max(curFreq, maxFreq);

        Stack<Integer> freqStack = freqGroup.computeIfAbsent(curFreq, k -> new Stack<>());
        freqStack.push(x);
    }
    
    public int pop() {
        Stack<Integer> stack = freqGroup.get(maxFreq);
        int ret = stack.pop();
        freq.put(ret, freq.get(ret) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}