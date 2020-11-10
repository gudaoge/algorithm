/*
[1414]和为 K 的最少斐波那契数字数目
find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
//给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。 
//
// 斐波那契数字定义为： 
//
// 
// F1 = 1 
// F2 = 1 
// Fn = Fn-1 + Fn-2 ， 其中 n > 2 。 
// 
//
// 数据保证对于给定的 k ，一定能找到可行解。 
//
// 
//
// 示例 1： 
//
// 输入：k = 7
//输出：2 
//解释：斐波那契数字为：1，1，2，3，5，8，13，……
//对于 k = 7 ，我们可以得到 2 + 5 = 7 。 
//
// 示例 2： 
//
// 输入：k = 10
//输出：2 
//解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
// 
//
// 示例 3： 
//
// 输入：k = 19
//输出：3 
//解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10^9 
// 
// Related Topics 贪心算法 数组

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P1414FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        //Solution solution = new P1414FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
    }

    /**
     * 思路：
     * 乍一看优先采用较大的数组合即可
     * 证明：
     * 1.首先不会选择相邻的数，因为相邻的数可以合并，使总数量减1
     * 2.其次不会选择相同的数，因为fn + fn = fn-1 + fn-2 + fn = fn+1 + fn-2
     * 经过2后会增加1合并的可能性，因此可能的组合为
     * fn + fn-2 + fn-4 + ...
     * 最后要证明要选择不大于k的最大数
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinFibonacciNumbers(int k) {
        //寻找不大于k的最大数
        int a = 1;
        int b = 1;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(1);

        while (a + b <= k) {
            int c = a + b;
            stack.addLast(c);

            a = b;
            b = c;
        }

        int res = 0;

        while (k > 0) {
            if (stack.peekLast() <= k) {
                k = k - stack.peekLast();
                res++;
            }
            stack.pollLast();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}