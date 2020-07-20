/*
[64]最小路径和
minimum-path-sum
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P64MinimumPathSum {
    public static void main(String[] args) {
        //Solution solution = new P64MinimumPathSum().new Solution();
    }

    /**
     * 思路：
     * 类似前两题，到达该点的路径和为上方和左边的两个点的最小值
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
                int min = Integer.MAX_VALUE;
                if (i - 1 >= 0) {
                    min = Math.min(min, dp[i-1][j]);
                }
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i][j-1]);
                }
                if (min < Integer.MAX_VALUE) {
                    dp[i][j] += min;
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}