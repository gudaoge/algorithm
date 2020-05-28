/*
[102]二叉树的层序遍历
binary-tree-level-order-traversal
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

*/


package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        // Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 思路：
 * 构造一个队列
 * 每次遍历当前层的节点，并把下一层的节点放入队列
 * 当前层的节点遍历完毕的时候，队列中剩下的节点就是下一层的全部节点
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new LinkedList<>();

        //构建辅助队列 保存下一层次的所有节点
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            // 获取当前队列的大小 即当前层的节点数量
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            while (size > 0) {
                //从队列中取出前size个树 并将下一层的节点放入队列
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
            ret.add(level);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}