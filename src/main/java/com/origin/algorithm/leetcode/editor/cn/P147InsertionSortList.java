/*
[147]对链表进行插入排序
insertion-sort-list
//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.ListNode;

public class P147InsertionSortList {
    public static void main(String[] args) {
        //Solution solution = new P147InsertionSortList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 思路：
 * 每次从待排序链表中取一个
 * 依次跟已排序链表的节点进行比较
 * 找到第一个大于待排序节点
 * 找到第一个大于待排序节点的已排序节点
 * 插入到它之前
 * 由于链表为单链表，因此需要从已排序链表头部开始判断，并保存前驱节点
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);

        ListNode pre;
        ListNode cur;

        ListNode tail = head;

        //每次从待排序链表中取一个
        while (tail != null) {
            //每次从已排序链表开头进行判断
            pre = dummy;
            cur = dummy.next;

            while (cur != null && tail.val > cur.val) {
                pre = cur;
                cur = cur.next;
            }
            //走到已排序链表尾部或者找到比它数值大的节点
            //那么就要将该节点插入到pre与cur的中间
            ListNode temp = tail.next;

            tail.next = cur;

            pre.next = tail;

            tail = temp;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}