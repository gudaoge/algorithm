/*
[76]最小覆盖子串
minimum-window-substring
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    /**
     * 初步想法：
     * 使用双指针划分滑动窗口
     * 使用hashMap保存滑动窗口内的字符以及出现的次数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //s<t的情况？
        if (s.length() < t.length()) {
            return "";
        }
        if (s.length() <= 1) {
            return s.equals(t) ? s : "";
        }

        int left = 0;
        int right = 0;

        //初始化t
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
           put(tMap, c);
        }
        //左右指针包含的s的字符
        Map<Character, Integer> sMap = new HashMap<>();
        put(sMap, s.charAt(0));

        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;

        while (right < s.length()) {
            //判断当前的子串是否包含了t的所有字符
            if (contains(tMap, sMap)) {
                //包含所有字符时 保存当前的结果
                int curLen = right - left;
                if (curLen < length) {
                    length = curLen;
                    start = left;
                    end = right + 1;
                }
                //缩小包含的区间 左指针右移 移除原先左指针的字符
                remove(sMap, s.charAt(left));
                left++;
            } else {
                //不包含 右指针右移 增大包含的区间 加入right的字符
                right++;
                if (right < s.length()) {
                    put(sMap, s.charAt(right));
                }
            }
        }
        return s.substring(start, end);
    }

    private boolean contains(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            //获取当前sMap的对应的字符的数量
            Integer sCount = sMap.get(entry.getKey());
            //没有的话说明不匹配
            if (sCount == null) {
                return false;
            }
            //数量不足的话说明不匹配
            if (sCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private void put(Map<Character, Integer> map, Character character) {
        if (map.containsKey(character)) {
            map.put(character, map.get(character) + 1);
        } else {
            map.put(character, 1);
        }
    }

    private void remove(Map<Character, Integer> map, Character character) {
        Integer count = map.get(character);
        if (count == 1) {
            map.remove(character);
        } else {
            map.put(character, count - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}