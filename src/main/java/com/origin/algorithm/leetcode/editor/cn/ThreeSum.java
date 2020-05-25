/*
[15]三数之和
3sum
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 暴力解法：
     * 穷举所有的组合
     * 3重嵌套for循环
     * 时间复杂度O（n^3)
     * 优化版：
     * 先对数组排序
     * 然后固定第一个值，接下来问题就转换为有序数组求两数定值和
     * 对于该定值，采用双指针从两端逼近的做法
     * 注意：还需要结果集的去重
     * 关于双指针查有序数组两数之和定值的证明
     * 假设左右指针分别为left和right
     * 若nums[left]+nums[right] > target
     * 则nums[left]+nums[right+n] > nums[left]+nums[right] > target
     * nums[left+n]+nums[right] > nums[left]+nums[right] > target
     * nums[left+n]+nums[right+n] > nums[left]+nums[right] > target
     * 由此可推出右指针固定的情况下，不存在左指针使得两数之和等于target
     * 因此可以抛弃右指针当前的数，改为判断[left...right-1]子数组是否存在两数之和等于target
     * 即可得，当两数之和大于目标值时，只能左移右指针
     * 同理，若nums[left]+nums[right] < target
     * nums[left-n]+nums[right-n] > nums[left]+nums[right] < target
     * 即可得，当两数之和小于目标值时，只能右移左指针
     * 若nums[left]+nums[right] = target
     * 则有：
     * 1。nums[left]+nums[right-1] <= nums[left]+nums[right] = target
     * 若 nums[left]+nums[right-1] = nums[left]+nums[right]
     * 则可以继续移动左右指针
     * 若 nums[left]+nums[right-1] < nums[left]+nums[right]
     * 则需要右移左指针
     * 2。nums[left+1]+nums[right] >= nums[left]+nums[right] = target
     * 若 nums[left+1]+nums[right] = nums[left]+nums[right]
     * 则可以继续移动左右指针
     * 若 nums[left+1]+nums[right] > nums[left]+nums[right]
     * 则需要左移右指针
     * 一次循环，每次循环内左右指针遍历一次数组
     * 时间复杂度O（n^2）
     */
    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        //然后固定第一个值
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                //因为是升序数组，若第一个值都大于0了，那三数之和肯定大于0
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //比如前一个数是5，则前一轮的结果集可能是[nums[i-1],nums[x1], nums[y1]], 这一轮的结果是[nums[i],nums[x2], nums[y2]]
                //x1,y1范围[i, n], x2,y2范围[i+1, n]
                //即当前的结果集是前一轮的子集 需要跳过
                continue;
            }
            //求i之后的有序数组的两数之和=-nums[i]的
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                //两数之和等于目标值
                if (nums[left] + nums[right] + nums[i] == 0) {
                    //保存结果
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //结果去重
                    //比如当前结果集为nums[left, x1], 下一轮结果集nums[left+1, x2]
                    //x1范围[left+1, n], x2范围[left+2, n]
                    //也就是下一个结果集是当前的子集 需要跳过下一个结果集，直到不相等
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    //随便移动一个指针
                    right--;
                    continue;
                }
                //两数之和大于目标值
                if (nums[left] + nums[right] + nums[i] > 0) {
                    //需要减小两数之和 左移右指针
                    right--;
                    continue;
                }
                //两数之和小于目标值
                if (nums[left] + nums[right] + nums[i] < 0) {
                    //需要增大两数之和 右移左指针
                    left++;
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}