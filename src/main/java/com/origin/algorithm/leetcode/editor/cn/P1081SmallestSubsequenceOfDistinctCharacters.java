/*
[1081]不同字符的最小子序列
smallest-subsequence-of-distinct-characters
//返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。 
//
// 
//
// 示例 1： 
//
// 输入："cdadabcc"
//输出："adbc"
// 
//
// 示例 2： 
//
// 输入："abcd"
//输出："abcd"
// 
//
// 示例 3： 
//
// 输入："ecbacba"
//输出："eacb"
// 
//
// 示例 4： 
//
// 输入："leetcode"
//输出："letcod"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母组成 
// 
//
// 
//
// 注意：本题目与 316 https://leetcode-cn.com/problems/remove-duplicate-letters/ 相同 
// Related Topics 栈 贪心算法 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P1081SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        //Solution solution = new P1081SmallestSubsequenceOfDistinctCharacters().new Solution();
    }

    /**
     * 思路：
     * 对于字符i，若后续还会出现，则此i为可选项，否则为必选项
     * 遍历字符串，将可选的i放入生成字符串的末尾
     * 若在生成字符串的末尾存在比i大的字符，并且该字符为可选项，则该字符可删除
     * 对于必选项字符x，并且该字符前有比i大的字符y，此时也不可删除y
     * 因为在遍历到x时，y要么必须，要么比x小，否则y在那时就会被删除
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {

        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            set.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}