/*
[130]被围绕的区域
surrounded-regions
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P130SurroundedRegions {
    public static void main(String[] args) {
        //Solution solution = new P130SurroundedRegions().new Solution();
    }

    /**
     * 思路：
     * 按题目所说，在边界上的O以及与它相连的O不会被填充，除此之外都会被填充
     * 也即是需要将全部的O划分为多个相连的集合，判断集合中是否包含边界O
     * 因此采用并查集解法
     * 并查集三步骤：
     * 1。初始化
     * 2。查找
     * 3。合并
     *
     * 思路调整
     * 最终目的是判断节点是否与任意一个边界O在同一个集合中，因此将所有的边界O放入同一个集合中
     * 最终只需要判断节点是否在边界O的集合中
     * 二维数组表示节点太麻烦，通过映射转为一维数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int row;
    private int col;
    private int[] array;
    private int dummyNode;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        //初始化
        init(board);
        //查找合并
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    //边界O合并到dummy的集合中
                    merge(node(i, j), dummyNode);
                } else {
                    //非边界O 与上下左右的O进行合并
                    if (board[i-1][j] == 'O') {
                        merge(node(i, j), node(i - 1, j));
                    }
                    if (board[i][j-1] == 'O') {
                        merge(node(i, j), node(i, j - 1));
                    }
                    if (board[i+1][j] == 'O') {
                        merge(node(i, j), node(i + 1, j));
                    }
                    if (board[i][j+1] == 'O') {
                        merge(node(i, j), node(i, j + 1));
                    }
                }
            }
        }
        //判断节点是否与边界O在一个集合
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !isConnected(node(i, j), dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void init(char[][] board) {
        row = board.length;
        col = board[0].length;
        array = new int[row * col + 1];
        dummyNode = row * col;

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

    private boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}