/*
[322]零钱兑换
coin-change
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P322CoinChange {
    public static void main(String[] args) {
        //Solution solution = new P322CoinChange().new Solution();
    }

    /**
     * 思路：
     * 假设硬币个数为f(n)
     * 则 f(n) = min(f(n-coin[x])) + 1   f(n-coin[x]) > -1
     * 即尝试依次选择每一种硬币，使得剩余的金额能够组成并且数量最小
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
               //尝试选择一个硬币，使得剩余的数量能够凑成并且最小
                if (i >= coin && dp[i - coin] > -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                //说明无法凑成
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}