/*
[1296]划分数组为连续数字的集合
divide-array-in-sets-of-k-consecutive-numbers
//给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。 
//如果可以，请返回 True；否则，返回 False。 
//
// 
//
// 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3,4,4,5,6], k = 4
//输出：true
//解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//输出：true
//解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3,2,2,1,1], k = 3
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,2,3,4], k = 3
//输出：false
//解释：数组不能分成几个大小为 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 1 <= k <= nums.length 
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P1296DivideArrayInSetsOfKConsecutiveNumbers {
    public static void main(String[] args) {
        Solution solution = new P1296DivideArrayInSetsOfKConsecutiveNumbers().new Solution();
        int[] arr = new int[]{1,2,3,3,4,4,5,6};

        solution.isPossibleDivide(arr, 4);
    }

    /**
     * 思路：
     * 因为要求连续子数组，那么对于数组中的最小元素，必定在子数组中最小
     * 即从该元素开始的k个数的数量必定不小于当前元素
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            Integer small = map.remove(num);
            if (small != null && small > 0) {
                for (int i = 1; i < k; i++) {
                    Integer large = map.get(num + i);
                    if (large == null || large < small) {
                        return false;
                    }
                    map.put(num + i, large - small);
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}