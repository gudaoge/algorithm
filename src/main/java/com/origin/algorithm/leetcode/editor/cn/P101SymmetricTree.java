/*
[101]对称二叉树
symmetric-tree
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P101SymmetricTree {
    public static void main(String[] args) {
        //Solution solution = new P101SymmetricTree().new Solution();
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
 * 若一个树镜像对称，那么只需要左右子树对称
 * 要判断两个树对称，那么需要：
 * 1。树的根节点相同
 * 2。左树的左子树跟右树的右子树对称
 * 2。左树的右子树跟左树的左子树对称
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricIterator(root);
    }

    /**
     * 迭代版
     * 广度优先搜索
     * @param root
     * @return
     */
    private boolean isSymmetricIterator(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode[] level = queue.toArray(new TreeNode[0]);
            queue.clear();
            //判断这一层的是否对称
            for (int i = 0; i < level.length; i++) {
                TreeNode cur = level[i];
                TreeNode next = level[level.length - 1 - i];
                //判断对应节点是否相等
                if (cur == null) {
                    if (next != null) {
                        return false;
                    }
                } else {
                    if (next == null) {
                        return false;
                    }
                    if (cur.val != next.val) {
                        return false;
                    }
                }
                //添加下一层的节点
                if (cur != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return true;
    }

    /**
     * 递归版
     * 深度优先搜索
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        //不等就是不对称
        if (left == null) {
            return right == null;
        } else {
            if (right == null) {
                return false;
            } else {
                return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}