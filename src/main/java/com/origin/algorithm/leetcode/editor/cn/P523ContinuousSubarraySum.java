/*
[523]连续的子数组和
continuous-subarray-sum
//给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其
//中 n 也是一个整数。 
//
// 
//
// 示例 1：
//
// 输入：[23,2,4,6,7], k = 6
//输出：True
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
// 
//
// 示例 2： 
//
// 输入：[23,2,6,4,7], k = 6
//输出：True
//解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
// 
//
// 
//
// 说明： 
//
// 
// 数组的长度不会超过 10,000 。 
// 你可以认为所有数字总和在 32 位有符号整数范围内。 
// 
// Related Topics 数学 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P523ContinuousSubarraySum {
    public static void main(String[] args) {
        //Solution solution = new P523ContinuousSubarraySum().new Solution();
    }

    /**
     * 思路：
     * 暴力解法，计算出所有的子数组的和
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i];
            if (k == 0 && dp[i] == 0) {
                return true;
            }
            if (k != 0 && dp[i] % k == 0) {
                return true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int i1 = dp[j] - dp[i - 1];
                if (k == 0 && i1 == 0) {
                    return true;
                }
                if (k != 0 && i1 % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}