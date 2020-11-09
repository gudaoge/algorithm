/*
[1353]最多可以参加的会议数目
maximum-number-of-events-that-can-be-attended
//给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 e
//ndDayi 。 
//
// 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。 
//
// 请你返回你可以参加的 最大 会议数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：events = [[1,2],[2,3],[3,4]]
//输出：3
//解释：你可以参加所有的三个会议。
//安排会议的一种方案如上图。
//第 1 天参加第一个会议。
//第 2 天参加第二个会议。
//第 3 天参加第三个会议。
// 
//
// 示例 2： 
//
// 输入：events= [[1,2],[2,3],[3,4],[1,2]]
//输出：4
// 
//
// 示例 3： 
//
// 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 输入：events = [[1,100000]]
//输出：1
// 
//
// 示例 5： 
//
// 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= events.length <= 10^5 
// events[i].length == 2 
// 1 <= events[i][0] <= events[i][1] <= 10^5 
// 
// Related Topics 贪心算法 排序 线段树

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1353MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        //Solution solution = new P1353MaximumNumberOfEventsThatCanBeAttended().new Solution();
    }

    /**
     * 思路：
     * 模拟开会过程，每次取当前可开的会议中结束时间最早的一个会议来开
     * 要获取最早的会议，使用最小堆来实现
     * 每天开始时，将这天开始的会议加入堆中
     * 然后从堆中取一个结束时间最早的会议
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int res = 0;
        int day = events[0][0];

        int index = 0;

        while (index < events.length || !heap.isEmpty()) {
            //添加当天开始的
            while (index < events.length && events[index][0] == day) {
                heap.offer(events[index][1]);
                index++;
            }
            //删除已经结束的
            while (!heap.isEmpty() && heap.peek() < day) {
                heap.poll();
            }
            //取当前最早结束的
            if (!heap.isEmpty()) {
                heap.poll();
                res++;
                day++;
            }
            //跳到下一个最早的开始时间
            if (heap.isEmpty() && index < events.length) {
                day = events[index][0];
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}