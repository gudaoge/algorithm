/*
[1558]得到目标数组的最少函数调用次数
minimum-numbers-of-function-calls-to-make-target-array
//
//
// 给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums 。 
//
// 请你返回将 arr 变成 nums 的最少函数调用次数。 
//
// 答案保证在 32 位有符号整数以内。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5]
//输出：5
//解释：给第二个数加 1 ：[0, 0] 变成 [0, 1] （1 次操作）。
//将所有数字乘以 2 ：[0, 1] -> [0, 2] -> [0, 4] （2 次操作）。
//给两个数字都加 1 ：[0, 4] -> [1, 4] -> [1, 5] （2 次操作）。
//总操作次数为：1 + 2 + 2 = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2]
//输出：3
//解释：给两个数字都加 1 ：[0, 0] -> [0, 1] -> [1, 1] （2 次操作）。
//将所有数字乘以 2 ： [1, 1] -> [2, 2] （1 次操作）。
//总操作次数为： 2 + 1 = 3 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [4,2,5]
//输出：6
//解释：（初始）[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [4,2,4] -> [4,2,
//5] （nums 数组）。
// 
//
// 示例 4： 
//
// 
//输入：nums = [3,2,2,4]
//输出：7
// 
//
// 示例 5： 
//
// 
//输入：nums = [2,4,8,16]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 0 <= nums[i] <= 10^9 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1558MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public static void main(String[] args) {
        //Solution solution = new P1558MinimumNumbersOfFunctionCallsToMakeTargetArray().new Solution();
    }

    /**
     * 思路：
     * 1.指定索引+1
     * 2.全部翻倍
     *
     * 对于奇数元素，只能由偶数加1得到
     * 对于偶数元素，可能由翻倍得到，也可能由+1得到
     *
     * 因此我们反过来处理
     * 1.将所有奇数-1
     * 2.全部减半
     * 循环1，2使所有元素全部为0
     *
     * TODO 更快的位运算解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {

        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
        }
        int res = 0;

        while (zero != nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1) {
                    nums[i]--;
                    res++;
                    if (nums[i] == 0) {
                        zero++;
                    }
                }
            }
            if (zero == nums.length) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i]/2;
            }
            res++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}