/*
[738]单调递增的数字
monotone-increasing-digits
//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P738MonotoneIncreasingDigits {
    public static void main(String[] args) {
        //Solution solution = new P738MonotoneIncreasingDigits().new Solution();
    }

    /**
     * 思路：
     * 要求不超过N的最大数字，那么高位需要尽可能选最大值
     * 若高位等于N的的高位，则后续位不可超过N的对应位
     * 若高位小于N的高位，则后续位直接设置为9
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int N) {

        StringBuilder stringBuilder = new StringBuilder();

        String s = String.valueOf(N);

        boolean low = false;

        for (int i = 0; i < s.length(); i++) {
            //需要大于等于list的末尾数字 并且小于等于s的当前字符
            if (low) {
                stringBuilder.append('9');
                continue;
            }
            if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) > s.charAt(i)) {
                //高位减一，遇到0或者前一位与其相等的继续往前找 因为减1后，当前会小于前一位，此时不满足递增条件
                int index = stringBuilder.length() - 1;
                while (stringBuilder.charAt(index) == '0' || (index > 0 && stringBuilder.charAt(index) == stringBuilder.charAt(index - 1))) {
                    stringBuilder.setCharAt(index, '9');
                    index--;
                }
                stringBuilder.setCharAt(index, (char)(stringBuilder.charAt(index) - 1));
                low = true;
                stringBuilder.append('9');
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}