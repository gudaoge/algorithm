/*
[169]多数元素
majority-element
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P169MajorityElement {
    public static void main(String[] args) {
        //Solution solution = new P169MajorityElement().new Solution();
    }

    /**
     * 思路：
     * 解法1:
     * 首先第一想到的就是用哈希表统计
     * 然而没有用到多数元素大于n/2这个条件
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * 解法2:
     * 其次可以采用排序后取中间位置的做法
     * 时间复杂度O（nlogn）
     *
     * 解法3:
     * 优化版的快速排序
     * 选定一个值x，将小于x的放左边，统计小于的数量a，同理大于x放右边，统计大于等于x的数量b
     * 若a<2/n，则多数元素在右边，否则在左边
     * 如此循环折半，直到找到多数元素
     *
     * 解法4:
     * TODO 摩尔投票法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            map.put(num, count);
        }
        //不可能走到这 随便返回个数字
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}