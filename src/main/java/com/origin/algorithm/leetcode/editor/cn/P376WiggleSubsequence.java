/*
[376]摆动序列
wiggle-subsequence
//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。 
//
// 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,
//4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。 
//
// 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。 
//
// 示例 1: 
//
// 输入: [1,7,4,9,2,5]
//输出: 6 
//解释: 整个序列均为摆动序列。
// 
//
// 示例 2: 
//
// 输入: [1,17,5,10,13,15,10,5,16,8]
//输出: 7
//解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。 
//
// 示例 3: 
//
// 输入: [1,2,3,4,5,6,7,8,9]
//输出: 2 
//
// 进阶: 
//你能否用 O(n) 时间复杂度完成此题? 
// Related Topics 贪心算法 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P376WiggleSubsequence {
    public static void main(String[] args) {
        //Solution solution = new P376WiggleSubsequence().new Solution();
    }

    /**
     * 思路：
     * 模拟子序列的构建过程可知
     * 每次都是将当前元素添加到所有已生成子序列的末尾
     * 前提条件为数字差符合摆动条件
     * 最终选出最长的子序列
     * TODO 解法优化
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][3];
        //无差值
        dp[0][0] = 1;
        //正差值
        dp[0][1] = 0;
        //负差值
        dp[0][2] = 0;

        for (int i = 1; i < nums.length; i++) {
            //自身作为一列
            dp[i][0] = 1;

            for (int j = 0; j < i; j++) {
                //尝试找到能接上去的最长子序列
                int dif = nums[i] - nums[j];
                if (dif == 0) {
                    continue;
                }
                //当前差为正值 需要找到j结尾的最大的最后差值为负的子序列或无差值的子序列
                if (dif > 0 && dp[j][2] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][2] + 1);
                }
                if (dif > 0 && dp[j][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                //当前差为负值 需要找到最大的最后差值为正的子序列或无差值的子序列
                if (dif < 0 && dp[j][1] > 0) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][1] + 1);
                }
                if (dif < 0 && dp[j][0] > 0) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][0] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
            max = Math.max(max, dp[i][2]);
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}