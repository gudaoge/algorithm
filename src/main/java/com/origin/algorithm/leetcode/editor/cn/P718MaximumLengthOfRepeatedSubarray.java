/*
[718]最长重复子数组
maximum-length-of-repeated-subarray
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        //Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
    }

    /**
     * 思路：
     * 暴力破解
     * 循环选定A中的每一位，寻找B中与A相同的数的位置，逐渐延伸至最大长度
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];

        int max = 0;
        for (int i = A.length-1; i >= 0; i--) {
            for (int j = B.length-1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    if (i+1 < A.length && j+1 < B.length) {
                        dp[i][j] = 1 + dp[i+1][j+1];
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}