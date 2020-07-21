/*
[120]三角形最小路径和
triangle
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.List;

public class P120Triangle {
    public static void main(String[] args) {
        //Solution solution = new P120Triangle().new Solution();
    }

    /**
     * 思路：
     * 每一个节点的路径和等于上一层节点和上一层前一个节点的最小值
     * 因此采用动态规划
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[1];
        for (List<Integer> list : triangle) {
            int index = 0;
            int[] temp = new int[list.size()];
            for (Integer node : list) {
                //取上一个节点和上一个节点前一个节点的最小值
                int min = Integer.MAX_VALUE;
                if (index >= 0 && index < dp.length) {
                    min = Math.min(min, dp[index]);
                }
                if (index-1 >= 0 && index-1 < dp.length) {
                    min = Math.min(min, dp[index-1]);
                }
                temp[index] = min + node;
                index++;
            }
            dp = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}