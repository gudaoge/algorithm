/*
[1578]避免重复字母的最小删除成本
minimum-deletion-cost-to-avoid-repeating-letters
//给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。 
//
// 返回使字符串任意相邻两个字母不相同的最小删除成本。 
//
// 请注意，删除一个字符后，删除其他字符的成本不会改变。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abaac", cost = [1,2,3,4,5]
//输出：3
//解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc", cost = [1,2,3]
//输出：0
//解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
// 
//
// 示例 3： 
//
// 
//输入：s = "aabaa", cost = [1,2,3,4,1]
//输出：2
//解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
// 
//
// 
//
// 提示： 
//
// 
// s.length == cost.length 
// 1 <= s.length, cost.length <= 10^5 
// 1 <= cost[i] <= 10^4 
// s 中只含有小写英文字母 
// 
// Related Topics 贪心算法

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P1578MinimumDeletionCostToAvoidRepeatingLetters {
    public static void main(String[] args) {
        //Solution solution = new P1578MinimumDeletionCostToAvoidRepeatingLetters().new Solution();
    }

    /**
     * 思路：
     * 需要删除的字母肯定是重复的，
     * 那么多个重复字母只需要保留一个，所以保留cost最大的那个
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(String s, int[] cost) {
        int index = 0;

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                if (cost[index] < cost[i]) {
                    res += cost[index];
                    index = i;
                } else {
                    res += cost[i];
                }
            } else {
                index = i;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}