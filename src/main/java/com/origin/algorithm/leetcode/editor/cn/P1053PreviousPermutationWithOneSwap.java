/*
[1053]交换一次的先前排列
previous-permutation-with-one-swap
//给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的
//最大可能排列。 
//
// 如果无法这么操作，就请返回原数组。 
//
// 
//
// 示例 1： 
//
// 输入：[3,2,1]
//输出：[3,1,2]
//解释：
//交换 2 和 1
// 
//
// 
//
// 示例 2： 
//
// 输入：[1,1,5]
//输出：[1,1,5]
//解释： 
//这已经是最小排列
// 
//
// 
//
// 示例 3： 
//
// 输入：[1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：
//交换 9 和 7
// 
//
// 
//
// 示例 4： 
//
// 输入：[3,1,1,3]
//输出：[1,3,1,3]
//解释：
//交换 1 和 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= A[i] <= 10000 
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1053PreviousPermutationWithOneSwap {
    public static void main(String[] args) {
        Solution solution = new P1053PreviousPermutationWithOneSwap().new Solution();
        solution.prevPermOpt1(new int[]{3,1,1,3});
    }

    /**
     * 思路：
     * 要使字典序比A小，那么从高位到低位中必须有一位小于A中对应位置
     * 要使得字典序最大，那么小于A的位必须最低
     * 对于该低位，必须是小于A的最大值
     * 若最大值有多个，必须是最末尾的那个
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prevPermOpt1(int[] A) {

        for (int i = A.length - 2; i >= 0 ; i--) {
            if (A[i] <= A[i+1]) {
                continue;
            }

            int max = i + 1;
            int j = max + 1;
            while (j < A.length && A[i] > A[j]) {
                if (A[j] > A[max]) {
                    max = j;
                }
                j++;
            }
            int temp = A[i];
            A[i] = A[max];
            A[max] = temp;
            return A;
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}