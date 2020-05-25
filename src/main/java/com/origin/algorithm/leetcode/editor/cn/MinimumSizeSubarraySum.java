/*
[209]长度最小的子数组
minimum-size-subarray-sum
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找

*/
package com.origin.algorithm.leetcode.editor.cn;
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
    }

    /**
     * 双指针问题
     * 正常解法：
     * 两个指针各遍历一次数组
     * 时间复杂度为O（n）
     *
     * 由于数组元素全部是正数
     * 所以sum是递增的
     * 即sum（0,x）<sum(0,x+y)
     * 有序数组查找可以考虑二分查找
     * 因此先进行一次遍历，计算所有sum
     * 然后固定左端点，二分寻找右端点
     * 因此需要n次遍历，每次遍历需要logn次查找
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = nums[left];
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}