/*
[283]移动零
move-zeroes
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    /**
     * 可以理解为每次从未处理子数组中挪动一个非0的数到已处理数组的末尾
     * 因此采用双指针，一个指向已处理子数组，一个指向未处理子数组
     * 每次交换前方的0与后方第一个非0的数
     * 两个指针分别遍历了一次数组 时间复杂度O(n)
     *
     * 考虑到末尾的全是0
     * 其实没必要进行交换操作，只需要统计0的个数
     * 并将非0数设置到前方即可
     * 因此只需要一个指针即可
     *
     * [0,0,1,0,1,1]
     * [1,1,1,0,1,1]
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public void moveZeroes(int[] nums) {
//        if (nums.length <= 1) {
//            return;
//        }
//        int left = 0;
//        int right = 1;
//        while (left < nums.length - 1) {
//            //左指针指向的位置之前肯定都是非0的处理过的
//            //所以需要从左指针后面找未处理的非0数
//            if (nums[left] == 0) {
//                //找到不为0的第一个数
//                while (right < nums.length && nums[right] == 0) {
//                    right++;
//                }
//                if (right == nums.length) {
//                    //说明没找到不为0的数了
//                    return;
//                }
//                //交换
//                swap(nums, left, right);
//                //处理下一个
//                left++;
//                right++;
//            } else {
//                left++;
//                //确保右指针在左指针前面
//                right = Math.max(right, left + 1);
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        //非0的子数组下标
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}