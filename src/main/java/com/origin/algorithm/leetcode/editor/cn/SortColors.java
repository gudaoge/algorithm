/*
[75]颜色分类
sort-colors
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    /**
     * 常规解法：
     * 一次遍历计数，
     * 二次遍历重写数组
     *
     * 双指针法：
     * 由于一共只有三种数
     * 所以排序后的结果为
     * [0....0 1...1 2...2]
     * 也就是分为三块[0, left],[left+1, right - 1], [right, n]
     * 因此采用两个指针分别指向left和right
     * 遍历数组，值只有三种，若为0，放入left指向的位置，若为2，放入right指向的位置
     * [2,0,2,1,1,0] ==> [0,0,1,1,2,2]
     *  ^         ^
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
                continue;
            }
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left++;
                cur++;
                continue;
            }
            if (nums[cur] == 1) {
                cur++;
            }
        }

    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}