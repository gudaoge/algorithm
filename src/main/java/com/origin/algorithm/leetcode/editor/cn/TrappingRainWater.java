/*
[42]接雨水
trapping-rain-water
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    /**
     * 这个问题可以抽象为
     * 选定左柱子
     * 1。若右边存在比他更高的柱子，则找到这最近的一个柱子
     * 2。若右边不存在比他更高的柱子，则找到最高的一个柱子
     *
     * 栈，动态规划等等的解法怎么实现？？？
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int a = 0;
        int total = 0;
        while (a < height.length - 1) {
            int b = a + 1;
            int maxIndex = b;

            while (b < height.length) {
                if (height[b] > height[a]) {
                    maxIndex = b;
                    break;
                } else {
                    if (height[b] > height[maxIndex]) {
                        maxIndex = b;
                    }
                    b++;
                }
            }
            //计算a到maxIndex的
            total += cal(height, a, maxIndex);
            a = maxIndex;

        }
        return total;
    }

    private int cal(int[] height, int left, int right) {
        int min = Math.min(height[left], height[right]);
        int total = 0;
        for (int i = left + 1; i < right; i++) {
            total += min - height[i];
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}