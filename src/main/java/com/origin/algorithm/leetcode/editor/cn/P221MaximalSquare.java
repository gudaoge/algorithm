/*
[221]最大正方形
maximal-square
//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P221MaximalSquare {
    public static void main(String[] args) {
        //Solution solution = new P221MaximalSquare().new Solution();
    }

    /**
     * 思路：
     * 假设以当前点向上和向左延伸围成的正方形边长为f(i,j) = x
     * 则当前点(i,j)的正方形的最大面积与左上点，上方点，左边点的正方形有关
     * 证明过程画图可知
     * 结论为f(i,j) = min(f(i-1,j-1), f(i-1,j), f(i, j-1)) + 1
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxSquare = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                //第一行列的特殊点
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    maxSquare = Math.max(maxSquare, 1);
                    continue;
                }
                int max = Math.min(dp[i-1][j-1], dp[i][j-1]);
                max = Math.min(max, dp[i-1][j]);
                dp[i][j] = max + 1;
                maxSquare = Math.max(maxSquare, dp[i][j]);
            }
        }
        return maxSquare * maxSquare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}