/*
[503]下一个更大元素 II
next-greater-element-ii
//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P503NextGreaterElementIi {
    public static void main(String[] args) {
        //Solution solution = new P503NextGreaterElementIi().new Solution();
    }

    /**
     * 思路：
     * 乍一看只需要循环遍历寻找每一个元素的下一个元素即可
     * 时间复杂度为O(N^2)
     * 每次遍历的过程能否复用呢？？？
     * 对于下标i，若下一个大于元素i的下标为j
     * 则可以得出[i,j]之间的元素肯定小于等于i
     * 因此可以维护一个单调不增栈，保存所有未找到下一个元素的元素下标
     * 遍历每个元素，当栈顶元素小于当前元素时，出栈，直至栈空
     * 特别的，因数组为循环数组，因此当栈内元素下标与当前元素下标相同时，说明循环一次了还未找到
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length * 2; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i%nums.length]) {
                ret[deque.peekLast()] = nums[i%nums.length];
                deque.pollLast();
            }
            if (deque.peekFirst() != null && deque.peekFirst() == i%nums.length) {
                ret[deque.peekFirst()] = -1;
                deque.pollFirst();
            }
            deque.addLast(i%nums.length);
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}