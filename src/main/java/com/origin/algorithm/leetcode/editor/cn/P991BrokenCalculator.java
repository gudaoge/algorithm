/*
[991]坏了的计算器
broken-calculator
//在显示着数字的坏计算器上，我们可以执行以下两种操作： 
//
// 
// 双倍（Double）：将显示屏上的数字乘 2； 
// 递减（Decrement）：将显示屏上的数字减 1 。 
// 
//
// 最初，计算器显示数字 X。 
//
// 返回显示数字 Y 所需的最小操作数。 
//
// 
//
// 示例 1： 
//
// 输入：X = 2, Y = 3
//输出：2
//解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
// 
//
// 示例 2： 
//
// 输入：X = 5, Y = 8
//输出：2
//解释：先递减，再双倍 {5 -> 4 -> 8}.
// 
//
// 示例 3： 
//
// 输入：X = 3, Y = 10
//输出：3
//解释：先双倍，然后递减，再双倍 {3 -> 6 -> 5 -> 10}.
// 
//
// 示例 4： 
//
// 输入：X = 1024, Y = 1
//输出：1023
//解释：执行递减运算 1023 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= 10^9 
// 1 <= Y <= 10^9 
// 
// Related Topics 贪心算法 数学

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P991BrokenCalculator {
    public static void main(String[] args) {
        Solution solution = new P991BrokenCalculator().new Solution();
        solution.brokenCalc(2, 3);
    }

    /**
     * 思路：
     * 首先需要将X增加到大于等于Y，然后再减少到Y
     * 对于任意增加后的X，
     * 若X>Y/2 （Y为偶数）
     * 若先翻倍再减少到Y一共需要1+2X-Y步，减少2X-Y步
     * 若先减少再翻倍到Y一共需要X-Y/2+1步，减少X-Y/2步
     * (1+2X-Y)-(X-Y/2+1) = X-Y/2 > 0
     *
     * 若X>(Y+1)/2 （Y+1为奇数）
     * 若先翻倍再减少到Y+1一共需要2X-(Y+1)+1步，减少2X-Y-1步
     * 若先减少到Y/2+1再翻倍到Y+2再减少到Y+1，一共需要X-(Y/2+1)+1+1，减少X-Y/2步
     * (1+2X-Y)-(X-(Y/2+1)+1+1) = X-Y/2 > 0
     *
     * 综上所述，应该先减少到Y/2+1再翻倍到Y+2再减少到Y+1，反复执行该步骤
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;

        while (X < Y) {
            if (Y % 2 > 0) {
                Y = Y/2 + 1;
                res += 2;
            } else {
                Y = Y/2;
                res += 1;
            }
        }

        return res + X - Y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}