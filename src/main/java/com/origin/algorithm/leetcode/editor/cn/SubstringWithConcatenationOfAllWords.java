/*
[30]串联所有单词的子串
substring-with-concatenation-of-all-words
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    }

    /**
     * 暴力解法：
     * 先计算每个word在s中的区间
     * 然后寻找是否存在连续的不重叠的区间使得每个word都存在
     * 注意：一个word可能会存在多个区间
     * 也即是可能需要做深度遍历加回溯
     * 可能想的太过复杂了
     * 注意条件 word长度相同
     * 换个思路看：
     * 类似双指针，一个a指针指向s当前字符，每次取word长度的子串比较，是否在words中，若存在，则匹配下一个word
     * 由于要匹配word是否相同，并且匹配过之后需要暂时移除word。因此考虑使用hash
     * 若不匹配，a指针右移一位
     *
     * 能不能在优化？？？
     * 能否通过已遍历过的结果过滤部分结果
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        int wordLength = words[0].length();
        HashMap<String, Integer> map = null;
        int a = 0;
        while (a < (s.length() - wordLength * words.length + 1)) {
            //初始化map
            map = new HashMap<>();
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            int index = a;
            while ((index + wordLength) <= s.length()) {
                String sub = s.substring(index, index + wordLength);
                if (map.containsKey(sub)) {
                    //移除map中的word
                    if (map.get(sub) == 1) {
                        map.remove(sub);
                    } else {
                        map.put(sub, map.get(sub) - 1);
                    }
                    //匹配下一个word
                    index += wordLength;
                } else {
                    //不匹配的情况 直接结束这次判断
                    break;
                }
            }
            //判断word都匹配了，因为每匹配一个就会移除一个word，所以全匹配的情况下map为空
            if (map.size() == 0) {
                list.add(a);
            }
            //进入下一次匹配
            a++;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}