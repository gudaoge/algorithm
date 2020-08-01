/*
[967]连续差相同的数字
numbers-with-same-consecutive-differences
//返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。 
//
// 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：N = 3, K = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
// 
//
// 示例 2： 
//
// 输入：N = 2, K = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 9 
// 0 <= K <= 9 
// 
// Related Topics 动态规划

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P967NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {
        //Solution solution = new P967NumbersWithSameConsecutiveDifferences().new Solution();
    }

    /**
     * 思路：
     * 模拟整个过程
     * 先定首位数，然后依次计算剩下位数
     * 假设首位为x，则次位为x+K，x-K， 结果必须大于等于0小于等于9
     * 特殊的，需要排除首位为0的数
     *
     * TODO dfs递归
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> set = new HashSet<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
            }
        };
        //长度为1的特别处理
        if (N == 1) {
            set.add(0);
            return toInt(set);
        }
        //大于1的
        for (int i = 2; i <= N; i++) {
            Set<Integer> temp = new HashSet<>();
            for (Integer integer : set) {
                int last = integer % 10;
                if (last + K <= 9) {
                    temp.add(integer * 10 + last + K);
                }
                if (last - K >= 0) {
                    temp.add(integer * 10 + last - K);
                }
            }
            set = temp;
        }
        return toInt(set);
    }

    private int[] toInt(Set<Integer> set) {
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            arr[index] = integer;
            index++;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}