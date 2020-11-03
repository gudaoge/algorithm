/*
[984]不含 AAA 或 BBB 的字符串
string-without-aaa-or-bbb
//给定两个整数 A 和 B，返回任意字符串 S，要求满足： 
//
// 
// S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母； 
// 子串 'aaa' 没有出现在 S 中； 
// 子串 'bbb' 没有出现在 S 中。 
// 
//
// 
//
// 示例 1： 
//
// 输入：A = 1, B = 2
//输出："abb"
//解释："abb", "bab" 和 "bba" 都是正确答案。
// 
//
// 示例 2： 
//
// 输入：A = 4, B = 1
//输出："aabaa" 
//
// 
//
// 提示： 
//
// 
// 0 <= A <= 100 
// 0 <= B <= 100 
// 对于给定的 A 和 B，保证存在满足要求的 S。 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P984StringWithoutAaaOrBbb {
    public static void main(String[] args) {
        //Solution solution = new P984StringWithoutAaaOrBbb().new Solution();
    }

    /**
     * 思路：
     * 按AABB的格式追加，然后将无法凑整的A或B删掉
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();

        if (A >= B) {
            int one = A - B;

            int two = A/2 - one;

            for (int i = 0; i < two; i++) {
                stringBuilder.append("aabb");
                A = A - 2;
                B = B - 2;
            }
            while (A > 0) {
                stringBuilder.append("a");
                A--;
                if (A > 0) {
                    stringBuilder.append("a");
                    A--;
                }
                if (B > 0) {
                    stringBuilder.append("b");
                    B--;
                }

            }

        } else {
            int one = B - A;

            int two = B/2 - one;

            for (int i = 0; i < two; i++) {
                stringBuilder.append("bbaa");
                A = A - 2;
                B = B - 2;
            }
            while (B > 0) {
                stringBuilder.append("b");
                B--;
                if (B> 0) {
                    stringBuilder.append("b");
                    B--;
                }
                if (A > 0) {
                    stringBuilder.append("a");
                    A--;
                }

            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}