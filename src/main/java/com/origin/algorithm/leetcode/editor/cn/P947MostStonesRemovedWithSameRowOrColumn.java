/*
[947]移除最多的同行或同列石头
most-stones-removed-with-same-row-or-column
//我们将石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。 
//
// 每次 move 操作都会移除一块所在行或者列上有其他石头存在的石头。 
//
// 请你设计一个算法，计算最多能执行多少次 move 操作？ 
//
// 
//
// 示例 1： 
//
// 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//输出：5
// 
//
// 示例 2： 
//
// 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//输出：3
// 
//
// 示例 3： 
//
// 输入：stones = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= stones[i][j] < 10000 
// 
// Related Topics 深度优先搜索 并查集

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P947MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        //Solution solution = new P947MostStonesRemovedWithSameRowOrColumn().new Solution();
    }

    /**
     * 思路：
     * 对于任意两个石头，若它们两个在同一行或列，则可以移除其中一个
     * 对于a，b，c三个石头，若ab同一行，bc同一列，则最多可以移除ac
     * 抽象来说，若任意两个石头在同一行或者同一列，则它们是连通的
     * 将所有石头能连通的连接起来，则它们之中除了最后一个石头，其他的全都可以删除
     *
     * 因此可以采用并查集 将石头按连通关系划分为多个集合，最终剩下的石头为每个集合的根节点
     * 这一点需要证明
     *
     * 优化版：
     * 由于同一行的或者同一列的都可以删除，所以可以将行或列视为一个元素
     * 这样就减少了元素数量
     *
     * 方法2
     * 根据石头坐标以及连通关系构建图
     * 每次删除度最少的大于0的石头
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] arr;

    public int removeStones(int[][] stones) {
        init();
        for (int[] stone : stones) {
            merge(stone[0], stone[1] + 10000);
        }

        Set<Integer> roots = new HashSet<>();
        for (int[] stone : stones) {
            roots.add(find(stone[0]));
            roots.add(find(stone[1] + 10000));
        }
        return stones.length - roots.size();
    }

    private void init() {
        arr = new int[20000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    private int find(int node) {
        if (arr[node] == node) {
            return node;
        }
        arr[node] = find(arr[node]);
        return arr[node];
    }

    private void merge(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        arr[root1] = root2;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}