/*
[268]缺失数字
missing-number
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P268MissingNumber {
    public static void main(String[] args) {
        //Solution solution = new P268MissingNumber().new Solution();
    }

    /**
     * 思路：
     * 解法1:
     * 先排序再进行一次遍历
     * 时间复杂度O(nlogn)
     *
     * 解法2:
     * 将数组元素放进哈希表
     * 然后从1到n遍历，查找哈希表中是否存在
     *
     * 解法3:
     * 异或
     * nums中的元素除了x之外都出现了一次
     * 1到n中的元素都出现了一次
     * 那么nums和1到n中的元素，x出现了一次，其他都出现了两次
     * 此时可以采取异或的方式
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        for (int i = 0; i <= nums.length; i++) {
            ret = ret ^ i;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}