/*
[494]目标和
target-sum
//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P494TargetSum {
    public static void main(String[] args) {
        //Solution solution = new P494TargetSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }

        int[] dp = new int[2001];

        dp[nums[0] + 1000] += 1;
        dp[-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[2001];
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] > 0) {
                    temp[j + nums[i]] += dp[j];
                    temp[j - nums[i]] += dp[j];
                }
            }
            dp = temp;
        }
        return dp[S + 1000];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}