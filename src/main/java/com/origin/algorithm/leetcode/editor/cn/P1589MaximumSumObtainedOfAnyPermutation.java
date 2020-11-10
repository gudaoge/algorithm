/*
[1589]所有排列中的最大和
maximum-sum-obtained-of-any-permutation
//有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums
//[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 en
//di 数组索引都是 从 0 开始 的。 
//
// 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。 
//
// 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
//输出：19
//解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
//requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
//requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
//总和为：8 + 3 = 11。
//一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
//requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
//requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
//总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
//输出：11
//解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
//输出：47
//解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 0 <= nums[i] <= 105 
// 1 <= requests.length <= 105 
// requests[i].length == 2 
// 0 <= starti <= endi < n 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class P1589MaximumSumObtainedOfAnyPermutation {
    public static void main(String[] args) {
        //Solution solution = new P1589MaximumSumObtainedOfAnyPermutation().new Solution();
    }

    /**
     * 思路：
     * 统计request所需的每个下标的数量
     * 然后将最大的数放到需要数量最大的下标上
     *
     * 注意：
     * 若采用遍历request对区间所有下标+1，时间复杂度O(n*m) 会超时
     * 因此采用差分数组统计，时间复杂度O(n+m)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        //差分数组 记录从i开始后每个元素增加的操作数
        int[] freq = new int[nums.length];

        for (int[] request : requests) {
            freq[request[0]]++;
            if (request[1] + 1 < nums.length) {
                freq[request[1] + 1]--;
            }

        }

        //将拆分数组转为前缀和 即每个元素总的操作数 即sum[i] = sum[i-1]+freq[i]
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i-1];
        }
        Arrays.sort(nums);
        Arrays.sort(freq);

        long res = 0;
        for (int i = nums.length - 1; i >= 0 && freq[i] > 0 ; i--) {

            res += (long) nums[i] * freq[i];
        }

        return (int) (res % 1000_000_007);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}