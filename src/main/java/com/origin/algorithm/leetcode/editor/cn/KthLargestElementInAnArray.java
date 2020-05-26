/*
[215]数组中的第K个最大元素
kth-largest-element-in-an-array
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    /**
     * 思路：
     * 要求第k大的数
     * 那么就需要保存前k个最大的数
     * 然后返回其中最小的
     * 因此需要一个大小为k的数组，保存最大值
     * 然后遍历每个元素
     * 若数字大于数组的最小值，则将该值放入，并维护数组大小
     *
     * 为了与k个数进行比较
     * 由此可以想到小根堆
     * 复杂度分析：
     * 每个元素都要入堆，时间复杂度 O（nlogk）
     * 消耗固定的k个空间，空间复杂度O（K）
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // TODO: 2020-05-26 堆的解法已实现  接下来实现快速选择的解法
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}