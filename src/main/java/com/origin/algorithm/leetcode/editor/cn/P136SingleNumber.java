/*
[136]只出现一次的数字
single-number
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P136SingleNumber {
    public static void main(String[] args) {
        //Solution solution = new P136SingleNumber().new Solution();
    }

    /**
     * 思路：
     * 使用哈希表统计出现次数
     * 然后找到出现次数为1的
     * 时间复杂度和空间复杂度都不是很好
     * 并且没有用到数据特性：每个元素出现2次，只有一个出现一次
     *
     * 所以可以采用异或的做法
     * 重复的值异或的结果=0
     * 与0异或的结果=自身
     *
     * 那么对于[a, b, b, c, c]
     * a ^ b ^ b ^ c ^ c = a ^ 0 ^ 0 = a
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}