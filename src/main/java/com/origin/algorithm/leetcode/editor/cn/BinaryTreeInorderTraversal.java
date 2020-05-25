/*
[94]二叉树的中序遍历
binary-tree-inorder-traversal
//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);

        root.right = right;
        right.left = left;

        solution.inorderTraversal(root);
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
 * 树的有序遍历
 * 使用递归实现最为简单
 *
 * 若需要使用迭代方式
 * 考虑模拟递归的实现，即采用栈的方式
 */
class Solution {
    List<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        iteration(root);

        return list;

    }

    /**
     * 迭代解法
     * 模拟递归的实现
     * @param root
     */
    private void iteration(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        //将自身入栈
        deque.addLast(root);
        // TODO: 2020-05-25 迭代的实现不够优雅
        Set<TreeNode> visited = new HashSet<>();

        TreeNode top = deque.peekLast();
        while (!deque.isEmpty()) {
            if (top.left != null) {
                if (!visited.contains(top.left)) {
                    deque.addLast(top.left);
                    top = deque.peekLast();
                    continue;
                }
            }
            list.add(top.val);
            deque.pollLast();
            visited.add(top);

            if (top.right != null) {
                deque.addLast(top.right);
            }
            top = deque.peekLast();
        }
    }

    /**
     * @param root 递归解法
     */
    private void traver(TreeNode root) {
        if (root == null) {
            return;
        }
        traver(root.left);
        list.add(root.val);
        traver(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}