/*
[111]二叉树的最小深度
minimum-depth-of-binary-tree
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        //Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
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
 * 遍历到每个叶子节点，计算深度
 *
 * 可以采用广度优先，每遍历一层，寻找这一层是否有叶子节点，有就直接返回
 * 可以采用深度优先，遍历每个叶子节点，找到最小的节点深度
 *
 * 这样看来，采用广度优先可能更快，因为可以尽快返回
 * 深度优先必须遍历所有节点
 *
 */
class Solution {
    public int minDepth(TreeNode root) {
        int deep = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            deep++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.right == null && node.left == null) {
                    return deep;
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return deep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}