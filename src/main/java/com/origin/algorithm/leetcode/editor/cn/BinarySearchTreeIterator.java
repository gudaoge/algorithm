/*
[173]二叉搜索树迭代器
binary-search-tree-iterator
//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {

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
 *
 * 初步思路：
 * 因为要实现O（1）时间复杂度的查找
 * 因此需要在初始化阶段将节点排序
 * 但是！！！
 * 注意条件：
 * 1。二叉搜索数特性  左子数的值最小，右子树的值最大，即中序遍历的结果就是从小到大的排列
 * 2。O（1）的时间复杂度
 * 3。O（h）的空间复杂度 可以联想到中序遍历过程中的节点路径
 * 因此可以猜想到
 * 利用栈保存中序遍历的路径
 * 每次调用next方法时相当于先序遍历的一次节点输出
 */
class BSTIterator {

    Deque<TreeNode> deque = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        //构建中序遍历的前一半
        while (root != null) {
            deque.addLast(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode top = deque.pollLast();
        TreeNode cur = top.right;
        while (cur != null) {
            deque.addLast(cur);
            cur = cur.left;
        }
        return top.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}