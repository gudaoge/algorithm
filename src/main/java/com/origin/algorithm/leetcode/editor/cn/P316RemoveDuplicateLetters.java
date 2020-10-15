/*
[316]去除重复字母
remove-duplicate-letters
//给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1: 
//
// 输入: "bcabc"
//输出: "abc"
// 
//
// 示例 2: 
//
// 输入: "cbacdcbc"
//输出: "acdb" 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
// Related Topics 栈 贪心算法 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class P316RemoveDuplicateLetters {
    public static void main(String[] args) {
        //Solution solution = new P316RemoveDuplicateLetters().new Solution();
    }

    /**
     * 思路：
     * 对于去重，可以采用哈希等方法
     * 由此可以生成若干个字符串
     * 但是题目还要求字典序最小
     * 因此我们需要比较生成的所有字符串，对其进行排序
     * 当然，暴力生成所有字符串排序肯定是不行的，因此需要分析如何生成最优字符串
     *
     * 假设我们逐步生成字符串
     * 当处理到索引i处的字符a时，
     * 若此时已生成的部分字符串尾部的字符b大于a
     * 1.字符b在后续还会出现，那么就可以删除该字符，因为在后续过程中该字符还会加入
     * 2.字符b不会再出现，那么不能删除，加入a到尾部，处理i+1的字符
     * 若字符b之前若有字符c小于a，那么能否删除呢？？？
     * 答案是不能，因为字符c要么不再出现，要么小于b，若删除了c，b会前移，导致字典序变大
     *
     * 因此综合下来可以得出结论
     * 每次都会生成近似升序字符排列的字符串
     * 因每次都将可删除的大字符删除了
     * 所以采用栈保存所有的生成字符，每次判断栈顶元素是否要删除
     * 为了判断能否删除，需要记录每个字符出现的最大位置，小于最大位置表示可删除
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {

        int[] lastIndexDic = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndexDic[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack  = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (set.contains(a)) {
                continue;
            }

            while (stack.peekLast() != null && stack.peekLast() > a && lastIndexDic[stack.peekLast() - 'a'] > i) {
                //当栈顶元素大于当前字符且后续还会出现时，删除该字符
                set.remove(stack.peekLast());
                stack.pollLast();
            }
            stack.addLast(a);
            set.add(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.removeFirst());
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}