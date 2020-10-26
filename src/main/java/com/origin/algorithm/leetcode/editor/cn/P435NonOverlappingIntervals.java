/*
[435]无重叠区间
non-overlapping-intervals
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class P435NonOverlappingIntervals {
    public static void main(String[] args) {
        //Solution solution = new P435NonOverlappingIntervals().new Solution();
    }

    /**
     * 思路：
     * 区间重叠问题优先想到排序
     * 排序后在进行重叠判断以及其他处理
     *
     * 对于重叠的区间，优先删除右端点更大的区间
     * TODO 其他解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int ret = 0;

        int left = 0;
        int right = 1;

        while (right < intervals.length) {
            int[] leftInterval = intervals[left];
            int[] rightInterval = intervals[right];

            if (rightInterval[0] >= leftInterval[0] && rightInterval[0] < leftInterval[1]) {
                //重叠了
                ret++;
                if (leftInterval[1] > rightInterval[1]) {
                    //左区间更长 删掉左区间
                    left = right;
                    right++;
                } else {
                    //删掉右区间
                    right++;
                }
            } else {
                //无重叠
                left = right;
                right++;
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}