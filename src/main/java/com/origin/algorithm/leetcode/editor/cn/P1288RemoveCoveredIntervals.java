/*
[1288]删除被覆盖区间
remove-covered-intervals
//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 贪心算法 排序 Line Sweep

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class P1288RemoveCoveredIntervals {
    public static void main(String[] args) {
        //Solution solution = new P1288RemoveCoveredIntervals().new Solution();
    }

    /**
     * 思路：
     * 对于区间重叠，首先要想到排序
     * 然后分析区间
     * 对于区间i，若i+1未被覆盖，i+2被i覆盖，则i+2必定被i+1覆盖
     * 由此可得，
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int index = 0;

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= intervals[index][1]) {
                res++;
            } else {
                index = i;
            }
        }
        return intervals.length - res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}