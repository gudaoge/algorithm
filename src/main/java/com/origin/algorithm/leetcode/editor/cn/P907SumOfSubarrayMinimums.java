/*
[907]子数组的最小值之和
sum-of-subarray-minimums
//给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。 
//
// 由于答案可能很大，因此返回答案模 10^9 + 7。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 
//
// 提示： 
//
// 
// 1 <= A <= 30000 
// 1 <= A[i] <= 30000 
// 
//
// 
// Related Topics 栈 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P907SumOfSubarrayMinimums {
    public static void main(String[] args) {
        //Solution solution = new P907SumOfSubarrayMinimums().new Solution();
    }

    /**
     * 思路：
     * 题目大意是遍历A的所有连续子数组，找个每个子数组的最小值，然后求和
     * 时间复杂度O(N^2)
     *
     * 分析最小值获取过程
     * 假设我们遍历每个数组每个元素结尾的子数组，则对应的子数组最小值分别为
     *
     * 10	9	8	7	9	8	4       最小值栈
     *
     *
     * 10								10
     * 9	9							9
     * 8	8	8						8
     * 7	7	7	7					7
     * 9	7	7	7	7				7	9
     * 8	8	7	7	7	7			7	8
     * 4	4	4	4	4	4	4		4
     *
     * 因此采用栈保存区间内的最小值，以及最小值的长度
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] A) {
        int sum = 0;
        int lastSum = 0;

        Stack<Integer> minStack = new Stack<>();
        Map<Integer, Integer> subLenMap = new HashMap<>();

        for (int a : A) {

            int count = 1;
            while (!minStack.isEmpty() && minStack.peek() >= a) {

                count += subLenMap.get(minStack.peek());
                lastSum -= subLenMap.get(minStack.peek()) * minStack.peek();

                subLenMap.remove(minStack.pop());
            }
            minStack.push(a);
            subLenMap.put(a, count);

            int subSum = count * a;

            int curSum = lastSum + subSum;

            lastSum = curSum;

            sum = (sum + curSum);
            sum = sum % 1000_000_007;
        }

        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}