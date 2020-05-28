/*
[231]2的幂
power-of-two
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P231PowerOfTwo {
    public static void main(String[] args) {
        //Solution solution = new P231PowerOfTwo().new Solution();
    }

    /**
     * 思路：
     * 解法1：
     * 若一个数为2的n次方
     * 因为int最大32位，所以一共就只有0～31种可能
     * 可以直接列举32个值
     * 直接判断给定数字是否在32个值之中
     *
     * 解法2：
     * 将一个数转换为2进制，则2次幂的数1的位数一定至多只有一个
     * 即逐位判断，统计1的个数
     *
     * 解法3：
     * 只保留最后一个为1的bit位
     * 由于2次幂只有一个1，那么保留的最后一个为1的bit其实也就是自身
     * 因此有: m & -m = m
     *
     * 解法4：
     * 消去最后一个1
     * 以为2次幂只有一个1 所以结果应该等于0
     * m & （m - 1） = 0
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isPowerOfTwo(int n) {
//        if (n < 0) {
//            return false;
//        }
//        //符号位需要算进去吗？
//        int count = 0;
//        for (int i = 0; i < 31; i++) {
//            if ((n & 1) == 1) {
//                count++;
//            }
//            n = n >> 1;
//        }
//        return count == 1;
//    }

//        public boolean isPowerOfTwo(int n) {
//            //解法3
//            return n > 0 && (n & -n) == n;
//        }

        public boolean isPowerOfTwo(int n) {
            //解法4
            return n > 0 && (n & (n - 1)) == 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}