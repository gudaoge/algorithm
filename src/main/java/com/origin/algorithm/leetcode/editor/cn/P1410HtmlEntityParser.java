/*
[1410]HTML 实体解析器
html-entity-parser
//「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。 
//
// HTML 里这些特殊字符和它们对应的字符实体包括： 
//
// 
// 双引号：字符实体为 &quot; ，对应的字符是 " 。 
// 单引号：字符实体为 &apos; ，对应的字符是 ' 。 
// 与符号：字符实体为 &amp; ，对应对的字符是 & 。 
// 大于号：字符实体为 &gt; ，对应的字符是 > 。 
// 小于号：字符实体为 &lt; ，对应的字符是 < 。 
// 斜线号：字符实体为 &frasl; ，对应的字符是 / 。 
// 
//
// 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "&amp; is an HTML entity but &ambassador; is not."
//输出："& is an HTML entity but &ambassador; is not."
//解释：解析器把字符实体 &amp; 用 & 替换
// 
//
// 示例 2： 
//
// 
//输入：text = "and I quote: &quot;...&quot;"
//输出："and I quote: \"...\""
// 
//
// 示例 3： 
//
// 
//输入：text = "Stay home! Practice on Leetcode :)"
//输出："Stay home! Practice on Leetcode :)"
// 
//
// 示例 4： 
//
// 
//输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
//输出："x > y && x < y is always false"
// 
//
// 示例 5： 
//
// 
//输入：text = "leetcode.com&frasl;problemset&frasl;all"
//输出："leetcode.com/problemset/all"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^5 
// 字符串可能包含 256 个ASCII 字符中的任意字符。 
// 
// Related Topics 栈 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class P1410HtmlEntityParser {
    public static void main(String[] args) {
        Solution solution = new P1410HtmlEntityParser().new Solution();
        solution.entityParser("and I quote: &quot;...&quot;");
    }

    /**
     * 思路：
     * 遍历字符串
     * 遇到&就开始解析，遇到;就停止
     * 并将&到;的子字符串替换
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String entityParser(String text) {
        Map<String, String> dic = new HashMap<>();
        dic.put("&quot;", "\"");
        dic.put("&apos;", "'");
        dic.put("&amp;", "&");
        dic.put("&gt;", ">");
        dic.put("&lt;", "<");
        dic.put("&frasl;", "/");

        int start = -1;

        int index = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while (index < text.length()) {

            char s = text.charAt(index);
            stringBuilder.append(s);
            if (s == '&') {
                start = stringBuilder.length() - 1;
            } else if (s == ';') {
                if (start >= 0) {
                    String sub = stringBuilder.substring(start, stringBuilder.length());
                    String parsed = dic.get(sub);
                    if (parsed != null) {
                        stringBuilder.delete(start, stringBuilder.length());
                        stringBuilder.append(parsed);
                    }
                    start = -1;
                }
            }
            index ++;
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}