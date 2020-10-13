/*
[880]索引处的解码字符串
decoded-string-at-index
//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤： 
//
// 
// 如果所读的字符是字母，则将该字母写在磁带上。 
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。 
// 
//
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。 
//
// 
//
// 示例 1： 
//
// 输入：S = "leet2code3", K = 10
//输出："o"
//解释：
//解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//字符串中的第 10 个字母是 "o"。
// 
//
// 示例 2： 
//
// 输入：S = "ha22", K = 5
//输出："h"
//解释：
//解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
// 
//
// 示例 3： 
//
// 输入：S = "a2345678999999999999999", K = 1
//输出："a"
//解释：
//解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= S.length <= 100 
// S 只包含小写字母与数字 2 到 9 。 
// S 以字母开头。 
// 1 <= K <= 10^9 
// 题目保证 K 小于或等于解码字符串的长度。 
// 解码后的字符串保证少于 2^63 个字母。 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P880DecodedStringAtIndex {
    public static void main(String[] args) {
        Solution solution = new P880DecodedStringAtIndex().new Solution();
        solution.decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp",
                976159153);
    }

    /**
     * 思路：
     * 解法1：
     * 生成最终的解码字符串，然后获取指定字符
     * 会消耗很大的空间
     *
     * 解法2：
     * 尽可能少生成字符串，即每次解码结束后判断下字符
     *
     * 解法3：
     * 假设我们保存原始编码字符串解码后字符串的最大长度
     * 那么应该就能根据索引和长度得到结果
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeAtIndex(String S, int K) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < S.length(); i++) {
//            if (Character.isDigit(S.charAt(i))) {
//                String temp = stringBuilder.toString();
//                for (int j = 1; j < Integer.valueOf(S.charAt(i) + ""); j++) {
//                    stringBuilder.append(temp);
//                }
//            } else {
//                stringBuilder.append(S.charAt(i));
//            }
//            if (stringBuilder.length() >= K) {
//                return stringBuilder.charAt(K-1) + "";
//            }
//        }
//        return "";

        //存储每个字符解码后字符串的长度
        Deque<Long> list = new LinkedList<>();

        list.addLast(1L);
        //指向还没处理的字符
        int index = 1;

        while (index < S.length()) {
            if (K == 1) {
                return S.charAt(0) + "";
            }

            char s = S.charAt(index);
            long end ;

            if (Character.isDigit(s)) {
                end = list.peekLast() * Long.parseLong(s + "");
            } else {
                end = list.peekLast() + 1L;
            }
            if (K > end) {
                //当前已解码的字符串长度未包含K，继续解码
                list.addLast(end);
                index ++;
            } else {
                //当前已解码长度包含了K，尝试获取

                if (K > list.peekLast()) {
                    //在当前区间内
                    if (Character.isLetter(s)) {
                        return s + "";
                    }
                    //数字情况下是前一段的重复，即nX+y,因此按按X取模，得到y
                    K = (int) ((K-1)%list.peekLast()) + 1;
                }

                list.pollLast();
                index --;

            }

        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}