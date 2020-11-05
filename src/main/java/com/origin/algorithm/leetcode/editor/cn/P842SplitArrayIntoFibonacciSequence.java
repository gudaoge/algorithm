/*
[842]将数组拆分成斐波那契序列
split-array-into-fibonacci-sequence
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P842SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {
        Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();
        solution.splitIntoFibonacci("123456579");
    }

    /**
     * 思路：
     * 关键是定出序列的前两个数字，定好了之后只需逐个生成后续数字判断是否满足即可
     * 由于0 <= F[i] <= 2^31 - 1
     * 即F[i]最多为10位数
     * 因此从1位到10位枚举前两数，判断是否满足
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        for (int i = 0; i < Math.min(S.length(), 10); i++) {
            if (S.charAt(0) == '0' && i > 0) {
                break;
            }
            long a = Long.parseLong(S.substring(0, i + 1));
            if (a >= Integer.MAX_VALUE) {
                break;
            }
            for (int j = i + 1; j < Math.min(S.length(), 10 + i); j++) {
                if (S.charAt(i+1) == '0' && j > i+1) {
                    break;
                }
                long b = Long.parseLong(S.substring(i+1, j+1));
                if (b >= Integer.MAX_VALUE) {
                    break;
                }
                List<Integer> list = new ArrayList<>();
                list.add((int) a);
                list.add((int) b);

                int k = j+1;
                boolean fail = false;
                while (k < S.length()) {
                    long next = list.get(list.size() - 1) + list.get(list.size() - 2);
                    String nextS = String.valueOf(next);

                    if (next > Integer.MAX_VALUE || !S.substring(k).startsWith(nextS)) {
                        fail = true;
                        break;
                    }
                    list.add((int) next);
                    k += nextS.length();
                }

                if (fail) {
                    continue;
                }
                if (list.size() >= 3) {
                    return list;
                }
            }

        }

        return new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}