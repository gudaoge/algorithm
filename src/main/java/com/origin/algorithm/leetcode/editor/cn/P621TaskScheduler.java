/*
[621]任务调度器
task-scheduler
//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 
//
// 示例 ： 
//
// 输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 
//
// 提示： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P621TaskScheduler {
    public static void main(String[] args) {
        //Solution solution = new P621TaskScheduler().new Solution();
    }

    /**
     * 思路：
     * 假设当前任务种类为x，若x<=n，则当前的执行时间为任务数量最大的任务所需要的时间
     * 因为有冷却时间，因此数量大的任务肯定要最先执行
     *
     * 解法1：
     * 统计每个任务的次数
     * 每次取n+1的剩余次数最多的任务执行
     * 直至任务执行完毕
     *
     * 解法2：
     * 模拟格子放任务，初始化max(task)轮，每轮n+1个格子
     * 然后依次将其他任务放入格子内，若还有剩余格子，则说明总时间就为最多的那个任务的时间
     * 若格子不够，则剩余的任务可以插到每轮格子的后面，此时总时间就是总任务数
     * 证明如下：
     * 因为格子轮数为最大的任务数，因此其他任务不会超过轮数，即同一轮不会出现多个同类型任务
     * 因此只需按顺序将任务放进格子，即满足冷却时间条件
     * 若此时有剩余格子，则说明格子数量够，此时时间就为最多的任务的时间
     * 若此时无剩余格子，则可以扩大每轮的格子数，将剩余任务依次放进去
     * 对于其他任务来说，彼此之前的间隔更大了，冷却时间条件满足，对于剩余任务来说，也满足冷却时间条件
     * 因此此时的总时间就是任务数量
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];

        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);

        int maxTask = map[25] - 1;

        int maxCell = maxTask * n;

        for (int i = 0; i < 25; i++) {
            maxCell -= Math.min(map[i], maxTask);

        }
        return maxCell > 0 ? tasks.length + maxCell : tasks.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}