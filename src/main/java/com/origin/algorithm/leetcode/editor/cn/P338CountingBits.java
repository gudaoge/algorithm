/*
[338]比特位计数
counting-bits
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P338CountingBits {
    public static void main(String[] args) {
        //Solution solution = new P338CountingBits().new Solution();
    }

    /**
     * 思路：
     * m&(m-1)的结果相当于m消去了一个1
     * 假设x中1的个数为f(x)
     * 则f(x)= f(x&x-1)+1
     * 时间复杂度O(n)
     *
     * TODO 其他解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i&(i-1)] + 1;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}