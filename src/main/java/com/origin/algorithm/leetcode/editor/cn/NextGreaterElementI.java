/*
[496]下一个更大元素 I
next-greater-element-i
//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;
public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
    }

    /**
     * 思路：
     * 使用两个指针a，b，
     * a指向nums1当前比较的元素
     * b指向nums2中等于nums1当前的元素 由于nums1是nums2的子集 因此一定可以在nums2中找到等于nums1的元素
     * 在nums2中寻找b之后的大于nums[a]的的元素
     * 时间复杂度O（n^2）
     * 但是这种做法没有使用到栈
     * 栈的实现方式？？？
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TODO: 2020-05-26 栈的实现
        int[] ret = new int[nums1.length];

        for (int a = 0; a < nums1.length; a++) {
            int index = -1;
            int b = nums2.length - 1;
            while (nums2[b] != nums1[a]) {
                if (nums2[b] > nums1[a]) {
                    index = b;
                }
                b--;
            }
            //说明走到相等的点
            ret[a] = index == -1 ? -1 : nums2[index];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}