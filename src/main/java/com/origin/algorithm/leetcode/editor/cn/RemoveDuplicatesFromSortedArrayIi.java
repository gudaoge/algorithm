/*
[80]删除排序数组中的重复项 II
remove-duplicates-from-sorted-array-ii
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
    }

    /**
     * 思路：
     * 数组有序判断是否重复3次
     * 即只需要判断第三个数是不是与前两个数都相等即可
     * 若相等则删除第三个数
     * 因此需要三个指针，或者说两个指针
     * 一个指向无重复数组的最后两个数，一个指向当前需要校验的数据
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int left = 1;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] == nums[left] && nums[right] == nums[left - 1]) {
                //说明重复了第三次，需要删除
                right ++;
            } else {
                //未重复三次 保存当前数据
                nums[left + 1] = nums[right];
                left ++;
                right++;
            }
        }
        return left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}