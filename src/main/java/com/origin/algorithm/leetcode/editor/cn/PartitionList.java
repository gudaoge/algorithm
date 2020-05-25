/*
[86]分隔链表
partition-list
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
     * 初步想法：
     * 一次遍历，将小于x的节点剥离，构成新链表
     * 然后将新旧链表拼接
     */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNew = new ListNode(0);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode newTail = dummyNew;
        while (cur.next != null) {
            if (cur.next.val < x) {
                //小于x时，将节点挪到小数链表中去
                newTail.next = cur.next;
                newTail = newTail.next;
                cur.next = cur.next.next;

            } else {
                cur = cur.next;
            }
        }
        //然后将两个链表拼接
        newTail.next = dummyHead.next;
        return dummyNew.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}