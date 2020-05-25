/*
[167]两数之和 II - 输入有序数组
two-sum-ii-input-array-is-sorted
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找

*/
package com.origin.algorithm.leetcode.editor.cn;
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }

    /**
     * 典型的双指针问题
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            }
            if (sum == target) {
                //下标是从1开始的 不是0，需要加1
                return new int[] {left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            }
        }
        //说明没找到
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}