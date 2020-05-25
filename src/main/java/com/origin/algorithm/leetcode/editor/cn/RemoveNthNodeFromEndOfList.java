/*
[19]删除链表的倒数第N个节点
remove-nth-node-from-end-of-list
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

    /**
     * 暴力解法：
     * 先进行一次遍历，获取链表长度
     * 计算得出目标节点的索引
     * 再进行第二次遍历，定位到指定索引进行删除
     * 一共需要进行两次遍历操作
     * 双指针法：
     * 采用快慢指针，快指针前进n步后，慢指针才开始行动，这样慢指针与快指针的差距就是n
     * 快指针到链表末尾时，慢指针在链表倒数第n位上
     * 特别的，为了防止删除的是头节点，因此需要构建一个虚拟头节点
     * 返回虚拟头节点的下一个节点
     */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int step = n;
        while (fast.next != null) {
            fast = fast.next;
            step--;
            if (step < 0) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}