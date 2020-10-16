/*
[636]函数的独占时间
exclusive-time-of-functions
//给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。 
//
// 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。 
//
// 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻
//开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。 
//
// 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。 
//
// 示例 1: 
//
// 输入:
//n = 2
//logs = 
//["0:start:0",
// "1:start:2",
// "1:end:5",
// "0:end:6"]
//输出:[3, 4]
//说明：
//函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
//现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
//函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
//所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
// 
//
// 说明： 
//
// 
// 输入的日志会根据时间戳排序，而不是根据日志Id排序。 
// 你的输出会根据函数Id排序，也就意味着你的输出数组中序号为 0 的元素相当于函数 0 的执行时间。 
// 两个函数不会在同时开始或结束。 
// 函数允许被递归调用，直到运行结束。 
// 1 <= n <= 100 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.List;
import java.util.Stack;

public class P636ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        //Solution solution = new P636ExclusiveTimeOfFunctions().new Solution();
    }

    /**
     * 思路：
     * 对于函数调用，可能存在函数内调用其他函数的情况，所以我们需要用栈来模拟
     * 当函数开始时入栈，函数结束时出栈，由此我们可以得到当前正在运行中的函数
     *
     * 对于一条函数开始日志，它的上一条日志可能是开始，可能是结束
     * 当上一条函数为开始时，则上一条时间到现在为上一个函数（此时为栈顶）执行时间
     * 当上一条函数为结束时，则上一条时间到现在为栈顶函数执行时间
     *
     * 它的下一条日志可能是开始，也可能是结束
     * 当下一条为开始时，则现在到下一条时间为当前函数执行时间（此时不处理，因为处理到下一条的时候会处理）
     * 当下一条为结束时，肯定是自身的结束，则当前到下一条结束的时间为自身执行时间（此时不处理，因为下一条会处理）
     *
     * 对于一条函数结束日志，它的上一条可能是开始，也可能是结束
     * 对于上一条函数为开始时，肯定是自身的开始，则上一条开始到现在为自身的执行时间，即栈顶
     * 对于上一条函数为结束时，则上一条结束到现在为自身执行时间，即栈顶
     *
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ret = new int[n];

        if (logs.size() <= 1) {
            return ret;
        }

        Stack<Integer> stack = new Stack<>();

        Integer lastFuncId = null;
        boolean isLastStart = false;
        Integer lastTime = null;

        for (String log : logs) {
            String[] curLog = log.split(":");
            Integer funcId = Integer.parseInt(curLog[0]);
            boolean isStart = curLog[1].equals("start");
            Integer time = Integer.parseInt(curLog[2]);

            if (!stack.isEmpty()) {
                if (isStart) {
                    if (isLastStart) {
                        //当前为开始 上一条也为开始，则上一条开始到现在为上一条函数（栈顶）执行时间
                        //比如上一条为5，当前为7，则上一条执行时间为5，6，总长度为2
                        ret[stack.peek()] += time - lastTime;
                    } else {
                        //上一条为结束，当前为开始，则上一条结束到现在之前为栈顶函数执行时间
                        //比如上一条为5，当前为7，则栈顶执行时间为6，长度为1
                        ret[stack.peek()] += time - lastTime - 1;
                    }
                } else {
                    if (isLastStart) {
                        //当前为结束，上一条为开始，则上一条开始到现在为自身（栈顶）执行时间
                        //比如上一条为5，当前为7，则上一条执行时间为5，6，7，总长度为3
                        ret[stack.peek()] += time - lastTime + 1;
                    } else {
                        //当前为结束，上一条为结束，则上一条开始到现在为自身（栈顶）执行时间
                        //比如上一条为5，当前为7，则上一条执行时间为6，7，总长度为2
                        ret[stack.peek()] += time - lastTime;
                    }
                }
            }

            //当前处理完了，决定是入栈还是出栈
            if (isStart) {
                stack.push(funcId);
            } else {
                stack.pop();
            }

            lastFuncId = funcId;
            isLastStart = isStart;
            lastTime = time;

        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}