/*
[88]合并两个有序数组
merge-sorted-array
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    /**
     * 首先 由两个数组大小可以得到新数组的总大小
     * 其次 两个数组有序 则比较最大值只需要比较两个数组末尾两数
     * 因此 需要三个指针，一个指向新数组末尾，另外两个指向两个旧数组末尾
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int tail1 = m - 1;
        int tail2 = n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] > nums2[tail2]) {
                //将大值放到新数组末尾
                nums1[tail] = nums1[tail1];
                tail --;
                tail1--;
            } else {
                nums1[tail] = nums2[tail2];
                tail --;
                tail2--;
            }
        }
        //走到这可能有数组没走完
        while (tail1 >= 0) {
            nums1[tail] = nums1[tail1];
            tail --;
            tail1--;
        }

        while (tail2 >= 0) {
            nums1[tail] = nums2[tail2];
            tail --;
            tail2--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}