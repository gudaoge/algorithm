/*
[287]寻找重复数
find-the-duplicate-number
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找

*/
package com.origin.algorithm.leetcode.editor.cn;
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
    }

    /**
     * 数组长度为n+1，数组元素范围1～n
     * 假设都是无重复数据，按照顺序排列的话
     * 下标1的数字是1，下标2的数字是2，下标x的数字是x
     * 假设存在重复数字，则对应下标肯定存在了相同的数字
     * 因此采用遍历的方式，每次将对应数字放到正确的下标下，若下标已存在数据，则重复
     *
     * 上述方式不行，因为题目要求不能修改原数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}