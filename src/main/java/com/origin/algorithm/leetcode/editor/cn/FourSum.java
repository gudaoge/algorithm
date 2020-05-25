/*
[18]四数之和
4sum
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        solution.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 类似三数之和 略
     */
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        //数组排序
        Arrays.sort(nums);
        //先定前两数
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //如果当前值跟前一轮的值相同，则结果集重复
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //如果当前值跟前一轮的值相同，则结果集重复
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right --;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        right --;
                    }
                    if (temp > target) {
                        right --;
                    }
                    if (temp < target) {
                        left ++;
                    }
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}