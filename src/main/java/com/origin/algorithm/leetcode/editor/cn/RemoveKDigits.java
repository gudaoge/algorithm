/*
[402]移掉K位数字
remove-k-digits
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
    }

    /**
     * 思路：
     * 移除k位数字，是剩下的数字最小
     * 那么是否可以由局部最优解推导出最终最优解呢？
     * 移除k-1个数字得到的数字与移除k个数字得到的数字有何关联？？？
     *
     * 感觉问题可以转换为n-k个字符组成的数字最小
     * 即每次从字符串中选取一个最小的值
     * 每次可选取字符串索引范围位[lastSelectIndex + 1, n- (n-k)]
     * 假设n-k=4，
     * 当前选择第1个字符，则需要留3个字符 即：4-1 则字符串index最大为n-4
     * 当前选择第2个字符，则需要留2个字符 即：4-2 则字符串index最大为n-3
     * 当前选择第x个字符，则需要留4-x，则字符串index最大为n-（n-k-x）-1=k+x-1
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        // TODO: 2020-05-25 这种解法没有使用任何的栈或者贪心思想，不是常规解法，需要再研究
        StringBuilder stringBuilder = new StringBuilder();
        int total = num.length() - k;
        char[] chars = num.toCharArray();
        int lastSelectIndex = -1;
        for (int i = 1; i <= total; i++) {
            //每次从[lastSelectIndex + 1, k+x-1]选出最小的字符
            int min = lastSelectIndex + 1;
            for (int j = lastSelectIndex + 1; j <= k+i-1; j++) {
                if (chars[j] < chars[min]) {
                    min = j;
                }
            }
            //
            stringBuilder.append(chars[min]);
            lastSelectIndex = min;
        }

        //去掉前导0
        while (stringBuilder.length() >= 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}