/*
[547]朋友圈
friend-circles
//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P547FriendCircles {
    public static void main(String[] args) {
        //Solution solution = new P547FriendCircles().new Solution();
    }

    /**
     * 思路：
     * 标准的并查集问题
     *
     * TODO dfs做法该怎么实现
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] array;

    private int row;

    private int col;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        //初始化
        init(M.length);
        //查找合并
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    merge(i, j);
                }
            }
        }
        //统计集合数量 也即是根节点数量
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            roots.add(find(i));
        }
        return roots.size();
    }

    private void init(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    private int find(int node) {
        if (array[node] == node) {
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
}
//leetcode submit region end(Prohibit modification and deletion)

}