/*
[279]完全平方数
perfect-squares
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P279PerfectSquares {
    public static void main(String[] args) {
        //Solution solution = new P279PerfectSquares().new Solution();
    }

    /**
     * 思路：
     * 先列举一下数字的组合
     * 1 = 1
     * 2 = 1 + 1
     * 3 = 1 + 1 + 1
     * 4 = 4
     * 5 = 4 + 1
     * 6 = 4 + 1 + 1
     * 7 = 4 + 1 + 1 + 1
     * 8 = 4 + 4
     * 9 = 9
     * 10 = 9 + 1
     * 11 = 9 + 1 + 1
     * 12 = 9 + 1 + 1 + 1 = 4 + 4 + 4
     * 13 = 9 + 4
     * 14 = 9 + 4 + 1
     * 15 = 9 + 4 + 1 + 1
     * 16 = 16
     * 17 = 16 + 1
     * 假设每个数的组合为f(n)，组成的数的数量为g(n)，组合按降序排列，最大的完全平方数为x
     * 则f(n) = x + f(n-x)  g(n) = 1 + min(g(n-x))
     * 由于当前值依赖前值，可以采用动态规划
     *
     * TODO 贪心解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int nextMax = 4;
        int seed = 2;
        for (int i = 2; i <= n; i++) {
            while (nextMax <= i) {
                seed++;
                nextMax = seed * seed;
            }
            int minDp = Integer.MAX_VALUE;
            for (int j = seed - 1; j >= 1; j--) {
                minDp = Math.min(minDp, dp[i - j * j]);
            }
            dp[i] = minDp + 1;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}