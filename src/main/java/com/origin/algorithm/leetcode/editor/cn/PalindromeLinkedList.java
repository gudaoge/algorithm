/*
[234]回文链表
palindrome-linked-list
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
     * 暴力解法：
     * 转换成数组，判断两端是否相同
     *
     * 思考：
     * 若想判断回文，需要首尾相同
     * 因此需要可以前进与后退
     * 但是单链表无法实现后退
     *
     * 解决办法，修改链表
     * 将链表从中间开始，分割成两个子链表
     * 并将末尾的链表反转
     * 将问题转换成两个链表相等的判断
     * 首先进行一次遍历
     * 快慢指针定位到链表中间，并得到数组长度
     *
     */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // TODO
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}