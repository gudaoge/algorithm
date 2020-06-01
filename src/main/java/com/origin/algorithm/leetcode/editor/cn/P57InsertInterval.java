/*
[57]插入区间
insert-interval
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P57InsertInterval {
    public static void main(String[] args) {
        //Solution solution = new P57InsertInterval().new Solution();
    }

    /**
     * 思路：
     * 题目的意思可以理解为
     * 在区间列表中找到与新区间重叠的区间删除，然后插入新区间
     *
     * 因此一次遍历即可解决
     * 从区间列表左边出发，找到最后一个右区间小于新区间左区间的区间
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        boolean put = false;
        for (int i = 0; i < intervals.length; i++) {
            //如果新区间已经放入结果集了，说明后面的不可能重叠了
            if (put) {
                ret.add(intervals[i]);
                continue;
            }
            int isOverLoop = isOverLoop(intervals[i], newInterval);
            if (isOverLoop == -1) {
                //说明在新区间左边
                //不可能重叠，直接放入结果集
                ret.add(intervals[i]);
            }
            if (isOverLoop == 0) {
                //说明重叠了，将区间合并到新区间
                newInterval = merge(intervals[i], newInterval);
            }
            if (isOverLoop == 1) {
                //说明后面的不可能重叠了
                //将新区间放入结果集
                //将剩下的区间也放入结果
                ret.add(newInterval);
                ret.add(intervals[i]);
                put = true;
            }
        }
        //极端情况可能新区间就在末尾
        //所以新区间没放入结果集的话需要在这放入结果集
        if (!put) {
            ret.add(newInterval);
        }
        return ret.toArray(new int[0][]);

    }

        /**
         * 判断区间a相对于区间b的位置
         * @param a
         * @param b
         * @return -1表示a在b的左边 0表示有重叠 1表示a在b的右边
         */
    public int isOverLoop(int[] a, int[] b) {
        if (a[1] < b[0]) {
            return -1;
        }
        if (a[0] > b[1]) {
            return 1;
        }
        return 0;
    }

    public int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}