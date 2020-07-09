/*
[70]爬楼梯
climbing-stairs
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P70ClimbingStairs {
    public static void main(String[] args) {
        //Solution solution = new P70ClimbingStairs().new Solution();
    }

    /**
     * 思路：
     * 假设n阶楼梯，爬到顶的可能方法数为f(n)
     * 则爬到第n阶时可能由n-1阶爬上来，也有可能由n-2阶爬上来
     * 即f(n) = f(n-1)+f(n-2)
     * 特别的
     * 当只有1阶时，爬法为1种
     * 当只有0阶时，爬法为1种
     * 因此可以用动态规划
     *
     * TODO 快速幂
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //由于实际上只需要最后的结果 所以可以无需创建数组 而改用3个临时变量存储中间值
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}