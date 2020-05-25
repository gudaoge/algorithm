/*
[16]最接近的三数之和
3sum-closest
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }

    /**
     * 类似三数之和，只是此时求与目标值之差最小的值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //数组排序
        Arrays.sort(nums);
        int dif = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return temp;
                }
                //更新差值
                int currentDif = Math.abs(temp - target);
                if (currentDif < dif) {
                    total = temp;
                    dif = currentDif;
                }
                //大于目标值 需要减小 左移右指针
                if (temp > target) {
                    right--;
                }
                //小于目标值 需要增大 右移左指针
                if (temp < target) {
                    left++;
                }
            }
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}