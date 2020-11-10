/*
[1567]乘积为正数的最长子数组长度
maximum-length-of-subarray-with-positive-product
//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。 
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
//
// 请你返回乘积为正数的最长子数组长度。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
// 
//
// 示例 2： 
//
// 输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
//
// 示例 3： 
//
// 输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
// 
//
// 示例 4： 
//
// 输入：nums = [-1,2]
//输出：1
// 
//
// 示例 5： 
//
// 输入：nums = [1,2,3,5,-6,4,0,10]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1567MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        //Solution solution = new P1567MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
    }

    /**
     * 思路：
     * 首先以0为界，分割若干个子数组
     * 要使子数组为正数，则元素要么是正数，要么包含偶数个负数
     * 在每个子数组中记录负数开始的位置和结束的位置
     * 当子数组为负数时，随机删除开始或结束的负数，取长度最大的
     * 当子数组为正数时，子数组长度即是
     *
     * TODO dp解法
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxLen(int[] nums) {
        int res = 0;

        int index = 0;

        while (index < nums.length) {

            while (index < nums.length && nums[index] == 0) {
                index++;
            }
            if (index == nums.length) {
                break;
            }
            int start = index;

            int negStart = -1;
            int negEnd = -1;

            int flag = 1;

            //遍历数组直到遇到0或到数组末尾
            while (index < nums.length && nums[index] != 0) {
                if (nums[index] < 0) {
                    flag  =  -flag;
                    if (negStart == -1) {
                        negStart = index;
                    }
                    negEnd = index;
                }
                index++;
            }

            if (flag > 0) {
                res = Math.max(res, index - start);
            } else {
                res = Math.max(res, negEnd - start);
                res = Math.max(res, index - negStart - 1);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}