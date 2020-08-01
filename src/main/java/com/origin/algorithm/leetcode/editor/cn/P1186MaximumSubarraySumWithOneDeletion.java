/*
[1186]删除一次得到子数组最大和
maximum-subarray-sum-with-one-deletion
//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。 
//
// 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元
//素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 请看示例： 
//
// 示例 1： 
//
// 输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -10^4 <= arr[i] <= 10^4 
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1186MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        //Solution solution = new P1186MaximumSubarraySumWithOneDeletion().new Solution();
    }

    /**
     * 思路：
     * 暴力解法就是遍历所有子数组，并选择删除或不删除最小元素，得到元素总和
     * 因此，需要知道两个要素
     * 1.每个子数组的总和
     * 2.子数组的最小元素
     *
     * 对于每一个i结尾的子数组，都可以由i-1的子数字加上i元素得到，这样可以得到子数组元素和
     * 对于每个i结尾的子数组，都可以选择删除或者不删除i元素，这样可以得到删除或者不删除的子数组和
     *
     * 因此需要记录以i结尾的删除或者未删除元素的的和，设为f(x,y) 为最大元素和，x为数组下标，y为是否删除过元素 取值为0，1
     * 则:
     * f(x,0) = f(x-1,0) + nums[x]
     * f(x,1) = max(f(x-1,1) + nums[x], f(x-1,0))
     * 特别的，还有i单独作为子数组的情况
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[2];
        dp[0] = arr[0];
        dp[1] = 0;

        int max = dp[0];

        for (int i = 1; i < arr.length; i++) {
            int[] temp = new int[2];
            //未删除
            //当前值加上前一个i结尾的未删除过的子数组的最大值
            //自己单独作为子数组
            temp[0] = Math.max(dp[0] + arr[i], arr[i]);
            //删除
            //1.删除i，为前一个未删除过的子数组的最大值
            //2.不删除i，为当前值加上前一个删除过的子数组的最大值
            temp[1] = Math.max(dp[0], dp[1] + arr[i]);

            dp = temp;
            max = Math.max(max, dp[0]);
            max = Math.max(max, dp[1]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}