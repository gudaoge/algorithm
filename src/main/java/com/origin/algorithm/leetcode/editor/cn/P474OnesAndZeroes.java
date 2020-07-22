/*
[474]一和零
ones-and-zeroes
//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P474OnesAndZeroes {
    public static void main(String[] args) {
        //Solution solution = new P474OnesAndZeroes().new Solution();
    }

    /**
     * 思路：
     * 类似背包问题
     * m，n为背包容量
     * 字符串为物品
     * 现在需要在固定容量下放入尽可能多的物品
     * 假设当前第i个商品要放入
     * 则f(i, c) = f(i-1, c-i) + 1 或 f(i-1,c)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        //初始化背包为0和物品为0的情况
        for (int i = 0; i < strs.length; i++) {
            dp[i][0][0] = 0;
        }
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[0][i][j] = 0;
            }
        }

        //计算
        for (int i = 1; i < strs.length + 1; i++) {
            int count0 = count0(strs[i-1]);
            int count1 = strs[i-1].length() - count0;

            for (int x = 0; x < m+1; x++) {
                for (int y = 0; y < n+1; y++){
                    if (x >= count0 && y >= count1) {
                        dp[i][x][y] = Math.max(dp[i-1][x][y], dp[i-1][x-count0][y-count1] + 1);
                    } else {
                        dp[i][x][y] = dp[i-1][x][y];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int count0(String s) {
        return s.replace("1", "").length();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}