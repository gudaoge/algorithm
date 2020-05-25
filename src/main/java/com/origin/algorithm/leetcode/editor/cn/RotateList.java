/*
[61]旋转链表
rotate-list
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.io.Serializable;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
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

public class ListNode implements Serializable {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


    /**
     * 1.环形链表
     * 将链表转成环
     * 假设链表长度为n，则挪动n次之后链表恢复原本位置，因此只需挪动 k%n次即可， 而0<=k%n<n
     * 根据链表长度，则可以计算出新节点的位置
     * 假设链表长度为5，挪动4次
     * 则前4个为原链表末尾四个元素，第五个为原链表第一个元素，
     * 即：[0,1,2,3,4] ==> [1,2,3,4,0]
     * 即 k%n与链表末尾下标的关系为 (n - k%n) - 1
     * 此时新的头节点为尾节点的后继节点
     *
     * 2.双指针
     * 首先获取链表长度，取余后获得链表挪动的长度
     * 因为0<=k%n<n，所以可以将问题转换为求链表倒数第x个节点，x = k%n + 1
     * 假设链表长度为5，挪动4次
     * 则前4个为原链表末尾四个元素，第五个为原链表第一个元素，
     * 即：[0,1,2,3,4] ==> [1,2,3,4,0]
     * 即求倒数第五个节点，返回该节点的后继节点
     *
     */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //先统计链表长度
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        //计算旋转次数
        k = k % length;
        //链表成环
        tail.next = head;
        //找到新的尾节点
        tail = head;
        int index = 0;
        while (index != (length - k - 1)) {
            index ++;
            tail = tail.next;
        }
        //尾节点的下一个就是头节点
        ListNode target = tail.next;
        //拆环
        tail.next = null;
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}