/*
[23]合并K个排序链表
merge-k-sorted-lists
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
 *
 * 思路：
 * 有序链表或者数组的合并一般可以采取每个链表头节点取最小来实现
 * 证明如下：
 * 若有数组nums1，nums2，都为升序数组
 * 若nums1[0] < nums2[0]
 * 并有nums1[0] < nums1[0+]
 * nums2[0] < nums2[0+]
 * 即nums1[0]为当前最小值
 *
 * 不失一般性
 * 任意a，b；
 * 若nums1[a] < nums2[b]
 * 则有 nums1[a] < nums1[a+]
 * nums1[a] < nums2[b+]
 * 即当前nums[a]最小
 *
 * 由此可得，有序数组或链表的合并可以采用
 * n个指针分别指向当前数组或链表的开头
 * 指针指向的节点之前进行比较
 * 将最小值放入新数组或链表的末尾
 * 将最小值对应的指针右移
 * 继续比较
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);
        //构建一个堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                heap.add(listNode);
            }
        }
        ListNode tail = dummyNode;
        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            tail.next = top;
            tail = top;
            if (top.next != null) {
                heap.offer(top.next);
            }
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}