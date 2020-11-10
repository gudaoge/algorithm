/*
[1536]排布二进制网格的最少交换次数
minimum-swaps-to-arrange-a-binary-grid
//给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。 
//
// 一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。 
//
// 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。 
//
// 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,0,1],[1,1,0],[1,0,0]]
//输出：3
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
//输出：-1
//解释：所有行都是一样的，交换相邻行无法使网格符合要求。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[1,0,0],[1,1,0],[1,1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 200 
// grid[i][j] 要么是 0 要么是 1 。 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1536MinimumSwapsToArrangeABinaryGrid {
    public static void main(String[] args) {
        //Solution solution = new P1536MinimumSwapsToArrangeABinaryGrid().new Solution();
    }

    /**
     * 思路：
     * 交换i，j两行会使得i，j之间的行都下移
     * 统计每行右侧连续0的个数
     * 第1行需要n-1个0
     * 第2行需要n-2个0
     * ···
     * 第n行需要n-n个0
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwaps(int[][] grid) {
        int[] count = new int[grid.length];

        //统计每行最后一个1的位置 从而可得末尾连续0的个数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count[i] = j;
                }
            }
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            if (count[i] > i) {
                int k = -1;
                for (int j = i + 1; j < grid.length; j++) {
                    if (count[j] <= i) {
                        //寻找
                        k = j;
                        break;
                    }
                }
                if (k == -1) {
                    return -1;
                }
                //交换
                for (int j = k; j > i; j--) {
                    res++;
                    count[j] = count[j-1];
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}