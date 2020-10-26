/*
[55]跳跃游戏
jump-game
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P55JumpGame {
    public static void main(String[] args) {
        //Solution solution = new P55JumpGame().new Solution();
    }

    /**
     * 思路：
     * 解法1：
     * 采用动态规划，从数组末尾开始计算到达末尾的可能性
     * 时间复杂度O(N^2)
     * 空间复杂度O(N)
     *
     * 解法2：
     * 只要跳跃长度不为0就可以往前行动
     * 因此我们只要保证能跳过0点即可
     * 因此从后往前遍历，遇到0点时开始统计需要跳过的长度（即到0点的长度）
     * 当遍历到某点可以跳过0点长度，即清空到0点长度
     * 时间复杂度O(N)
     *
     * 解法3：
     * 当从某点跳跃到最远位置时，说明到最远位置内的点都可以到达
     * 那么遍历每个点，判断该点是否能到达，并且该点能到达时可以跳到的最远位置
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }

        return maxIndex >= nums.length - 1;
    }

        /**
         * 解法2
         * @param nums
         * @return
         */
//        public boolean canJump(int[] nums) {
//            int zeroIndex = -1;
//
//            for (int i = nums.length - 2; i >= 0; i--) {
//                if (nums[i] == 0) {
//                    if (zeroIndex < 0) {
//                        zeroIndex = i;
//                    }
//                } else {
//                    if (zeroIndex >= 0 && nums[i] > zeroIndex - i) {
//                        zeroIndex = -1;
//                    }
//                }
//            }
//
//            return zeroIndex < 0;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}