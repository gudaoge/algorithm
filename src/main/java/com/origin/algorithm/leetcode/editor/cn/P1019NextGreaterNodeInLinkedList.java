/*
[1019]链表中的下一个更大节点
next-greater-node-in-linked-list
//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。 
//
// 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.
//val，那么就有 j > i 且 node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0
// 。 
//
// 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。 
//
// 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 示例 3： 
//
// 输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 对于链表中的每个节点，1 <= node.val <= 10^9 
// 给定列表的长度在 [0, 10000] 范围内 
// 
// Related Topics 栈 链表

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.ListNode;

import java.util.*;

public class P1019NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        //Solution solution = new P1019NextGreaterNodeInLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * 思路：
     * 用栈保存所有遍历的还未找到下一个大值的节点
     * 遍历链表，比较节点值与栈顶元素的大小
     * 若栈顶元素小于节点，则说明栈顶元素找到了大值，栈顶出栈
     * 否则栈顶元素大于节点，将节点入栈
     * 如此反复操作，可以得到一个单调减的栈
     *
     * 此外，我们还需要保存节点的位置
     */
    class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();

        int[] ret = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            while (!stack.isEmpty() && nodes.get(stack.peek()) < nodes.get(i)) {
                ret[stack.pop()] = nodes.get(i);
            }
            stack.push(i);
        }
        //现在栈里剩下的都是无大值的 直接就是0

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}