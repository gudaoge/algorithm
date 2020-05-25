/*
[11]盛最多水的容器
container-with-most-water
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 暴力解法：
     * 双重循环，先定起始点，再定每个起始点能达到的对应最大容器的结束点
     * 时间复杂度O（n^2）
     * 因此有必要优化下
     * 双指针解法：
     * 1.首先初始化两个左右指针，分别指向数组开头和末尾
     * 2.更新最大容量
     * 3.移动较小值指针
     * 重复2，3步骤，直到指针相遇
     * 两个指针一起遍历了一遍数组，时间复杂度O（n）
     */
    class Solution {
    public int maxArea(int[] height) {
        //假设两点a，b构成的容器大小为 min(h[a],h[b]) * (b-a)
        //假设h[a]<h[b]
        //若固定a，移动b
        //则有min(h[a], h[b-x]) <= h[a] = min(h[a], h[b])
        //综上所述，右指针移动后最小值min(h[a], h[b-x])必定是<=min(h[a], h[b])
        //则min(h[a], h[b-x]) * (b-a-x) < min(h[a], h[b]) * (b-a)
        //因此容器的最大容量是递减的
        //即以a指针开始的容器容量最大的结束指针为b
        //所以应尝试固定b，移动a
        //此时min(h[a+x], h[b])与min(h[a], h[b])的关系无法确定
        //因此有容量增大的可能
        //同理可得h[a]>h[b]时 应固定a，移动b
        //综上所述 移动较小值的指针有容量增大的可能性
        //即每次抛弃一个较小值端点，剩下的节点继续参加容量判定
        int a = 0;
        int b = height.length - 1;

        int max = 0;
        while (a < b) {
            int cur = calculate(height, a, b);
            max = Math.max(cur, max);
            if (height[a] < height[b]) {
                a ++;
            } else {
                b --;
            }
        }
        return max;
    }

    private int calculate(int[] height, int a, int b) {
        return Math.min(height[a], height[b]) * (b-a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}