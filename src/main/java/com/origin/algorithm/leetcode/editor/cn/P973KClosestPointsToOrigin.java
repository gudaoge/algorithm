/*
[973]最接近原点的 K 个点
k-closest-points-to-origin
//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class P973KClosestPointsToOrigin {
    public static void main(String[] args) {
        //Solution solution = new P973KClosestPointsToOrigin().new Solution();
    }

    /**
     * 思路：
     * 生成每个点跟原点的距离，求最小的K个元素
     * 所以采用大根堆
     * 时间复杂度O(NlogK)
     *
     * 还可以采用优化版的快速选择算法
     * 选定一个距离X，将距离小于X的点放到左边，大于X的点放到右边
     * 若左边的数量大于K，则在左边的点继续选定X
     * 若左边的数量小于K，则在右边的点中寻找剩余的数量
     *
     * TODO 快速选择的解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class Point {
        int x;
        int y;
        int dis;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dis = x * x + y * y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>((o1, o2) -> o2.dis - o1.dis);

        for (int[] point : points) {
            heap.offer(new Point(point[0], point[1]));
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] ret = new int[K][2];
        int index = 0;
        for (Point point : heap) {
            ret[index] = new int[]{point.x, point.y};
            index++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}