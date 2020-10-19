/*
[456]132模式
132-pattern
//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 
//
// 注意：n 的值小于15000。 
//
// 示例1: 
//
// 
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
// 
//
// 示例 2: 
//
// 
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
// 
//
// 示例 3: 
//
// 
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class P456One32Pattern {
    public static void main(String[] args) {
        //Solution solution = new P456One32Pattern().new Solution();
    }

    /**
     * 思路：
     * 解法1：
     * 暴力破解，三重循环
     * 时间复杂度O(N^3)
     *
     * 解法2：
     * 记录每个元素之前的最小值
     * 遍历j，从j往后遍历寻找k
     * 时间复杂度O(N^2)
     *
     * 解法3：
     * 记录每个元素之前的最小值
     * 遍历j，寻找k
     * 对于每个j对应的最小值min[j]
     * 有min[j-1] >= min[j]
     * 因为j越往后越可能遇到更小值
     * 因此我们从后往前找k，保留大于min[j]的所有数字
     * 对于min[j-1]，因为min[j-1]>= min[j]，因此小于min[j]的数字本身也小于min[j-1]
     * 所以对于min[j-1]，只需要判断剔除小于min[j-1]的数，再判断nums[j]是否大于min[j-1]即可
     * 由此可得到所有大于min[j-1]的数，此时只需要找到小于nums[j-1]的数即可
     * 为了方便比较，我们将大于min[j-1]的数降序排列，这样第一个就是最小的大于min[j-1]的数，因此只需要判断第一个数是否满足即可
     * 因此我们采用单调减栈来维护降序数组
     *
     * 因为每个元素最多入栈出栈1次，所以时间复杂度O(N)
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i > 0; i--) {
            //清空之前的小于nums[j]的数
            while (!stack.isEmpty() && stack.peek() <= min[i]) {
                stack.pop();
            }
            //若此时存在小于nums[i]的的k，则符合132
            if (!stack.isEmpty() && stack.peek() < nums[i]) {
                return true;
            }
            //未找到，则栈中元素肯定都大于等于nums[j] 此时nums[j]本身就是最小值
            stack.push(nums[i]);
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}