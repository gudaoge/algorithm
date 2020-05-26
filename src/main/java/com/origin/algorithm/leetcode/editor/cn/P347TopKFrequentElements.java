/*
[347]前 K 个高频元素
top-k-frequent-elements
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表

*/


package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P347TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        // TO TEST
    }

    /**
     * 思路：
     * 求topK首先想到堆
     * 其次时间复杂度要求优于O(n log n)，已知的排序算法无法满足
     *
     * 因此：
     * 先进行一次遍历得出元素出现次数
     * 再将每个元素放入小根堆中，并维护小根堆的大小
     * 时间复杂度 O（nlogk）
     * 空间复杂度O(k)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //统计每个元素出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ret = new int[k];
        int index = 0;
        Iterator<Integer> iterator = heap.iterator();
        while (iterator.hasNext()) {
            ret[index] = iterator.next();
            index++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}