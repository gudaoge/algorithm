/*
[767]重构字符串
reorganize-string
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P767ReorganizeString {
    public static void main(String[] args) {
        //Solution solution = new P767ReorganizeString().new Solution();
    }

    /**
     * 思路：
     * 该题可以转换成冷却时间的题
     * 即要求相同的字母间隔必须大于等于1
     * 因此只需关注次数最多的字母，构建若干个格子
     * 若其他字母能填满该字母的格子，则说明可以实现
     * 否则不能
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        if (S.length() <= 1) {
            return S;
        }
        int[][] map = new int[26][2];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'][0] = S.charAt(i) - 'a';
            map[S.charAt(i) - 'a'][1] ++;
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        for (int[] arr : map) {
            if (arr[1] > 0) {
                heap.offer(arr);
            }
        }

        int maxCount = heap.peek()[1];
        if (S.length() - maxCount  < maxCount - 1) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        Queue<int[]> queue = new LinkedList<>();
        while (!heap.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                if (!heap.isEmpty()) {
                    int[] arr = heap.poll();
                    stringBuilder.append((char)(arr[0] + 'a'));
                    arr[1]--;
                    if (arr[1] > 0) {
                        queue.offer(arr);
                    }
                }
            }
            while (!queue.isEmpty()) {
                heap.offer(queue.poll());
            }
        }

        return stringBuilder.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}