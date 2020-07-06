/*
[200]岛屿数量
number-of-islands
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P200NumberOfIslands {
    public static void main(String[] args) {
        //Solution solution = new P200NumberOfIslands().new Solution();
    }

    /**
     * 思路：
     * 将相连的1构成一个集合，统计集合的数量
     * 因此采用并查集解法
     *
     * TODO bfs和dfs解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int row;
    private int col;
    private int[] array;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //初始化
        init(grid);
        //查找合并
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                //上下左右合并
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    merge(node(i, j), node(i - 1, j));
                }
                if (i + 1 < row && grid[i + 1][j] == '1') {
                    merge(node(i, j), node(i + 1, j));
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    merge(node(i, j), node(i, j - 1));
                }
                if (j + 1 < col && grid[i][j + 1] == '1') {
                    merge(node(i, j), node(i, j + 1));
                }
            }
        }

        //寻找集合数量，也就是寻找集合根节点
        Set<Integer> root = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    root.add(find(node(i, j)));
                }
            }
        }
        return root.size();
    }

    private void init(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        array = new int[row * col];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private int find(int node) {
        if (node == array[node]) {
            return node;
        }
        array[node] = find(array[node]);
        return array[node];
    }

    private void merge(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        array[root1] = root2;
    }

    private int node(int x, int y) {
        return col * x + y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}