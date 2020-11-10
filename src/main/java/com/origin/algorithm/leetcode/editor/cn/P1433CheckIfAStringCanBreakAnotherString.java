/*
[1433]检查一个字符串是否可以打破另一个字符串
check-if-a-string-can-break-another-string
//给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1 的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 
//的一个排列。 
//
// 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序
//）。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "abc", s2 = "xya"
//输出：true
//解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
// 
//
// 示例 2： 
//
// 输入：s1 = "abe", s2 = "acd"
//输出：false 
//解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："a
//cd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排
//列。
// 
//
// 示例 3： 
//
// 输入：s1 = "leetcodee", s2 = "interview"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// s1.length == n 
// s2.length == n 
// 1 <= n <= 10^5 
// 所有字符串都只包含小写英文字母。 
// 
// Related Topics 贪心算法 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class P1433CheckIfAStringCanBreakAnotherString {
    public static void main(String[] args) {
        //Solution solution = new P1433CheckIfAStringCanBreakAnotherString().new Solution();
    }

    /**
     * 思路：
     * 排序，然后逐字符比较
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int flag = arr1[0] - arr2[0];

        for (int i = 1; i < s1.length(); i++) {
            int flag1 = arr1[i] - arr2[i];
            if ((flag > 0 && flag1 < 0) || (flag < 0 && flag1 > 0)) {
                return false;
            }
            if (flag == 0 && flag1 != 0) {
                flag = flag1;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}