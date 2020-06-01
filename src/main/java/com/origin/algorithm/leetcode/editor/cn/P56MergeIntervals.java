/*
[56]合并区间
merge-intervals
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56MergeIntervals {
    public static void main(String[] args) {
        //Solution solution = new P56MergeIntervals().new Solution();
    }

    /**
     * 思路：
     * 区间重叠部分证明
     * 若a与b重叠，b与c重叠，a与c不重叠，那么ab与c重叠，bc与a重叠，那么abc可以合并
     * 若a与b不重叠，a与c不重叠，那么a无法跟bc重叠，ab，ac，abc无法合并
     * 由此可得区间具有传递性。
     *
     *
     *
     * 暴力破解：
     * 每次从数组中选一个区间
     * 寻找第一个与它重叠的区间
     * 若未找到，则将该区间输出
     * 若找到，则将该区间合并到重叠区间
     * 进入下一次循环
     *
     * 需要进行n次迭代，每次迭代最多需要遍历n-1个元素
     * 时间复杂度O（n^2）
     *
     * 可以先对区间进行排序
     * 然后从左开始依次合并区间
     *
     * 正确性证明：
     * 假设区间a < 区间b < 区间c
     * 区间a与b不重叠，则区间c与区间a一定不重叠
     * a的右区间一定小于b的左区间，由此可的a的右区间一定小于c的左区间
     * 因此ac不重叠
     * 也即是有序区间下，若a与b不重叠，则b之后的与a也不重叠
     *
     * 排序时间复杂度O(nlogn)
     * 合并时间复杂度O(n)
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //按照左区间进行排序
        //左区间相同的情况可以不管，因为可以直接合并了，顺序无所谓
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int i = 0;
        List<int[]> ret = new ArrayList<>();

        while (i < intervals.length) {
            int j = i + 1;
            //寻找与i重叠的区间并合并
            while (j < intervals.length) {
                if (hasOverLoop(intervals[i], intervals[j])) {
                    //重叠的情况
                    intervals[i] = merge(intervals[i], intervals[j]);
                    j++;
                } else {
                    //不重叠的情况
                    break;
                }
            }
            //走到这说明走到底或者遇到不重叠的区间了
            //所以要保存合并的区间i，并从j开始继续合并
            ret.add(intervals[i]);
            i = j;

        }

        return ret.toArray(new int[0][]);
    }

    private boolean hasOverLoop(int[] a, int[] b) {
        if (a[0] < b[0] && a[1] >= b[0]) {
            return true;
        }
        if (a[0] >= b[0] && a[0] <= b[1]) {
            return true;
        }
        return false;
    }

    private int[] merge(int[] a, int[] b) {
        return new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}