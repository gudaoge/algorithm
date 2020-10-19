/*
[1047]删除字符串中的所有相邻重复项
remove-all-adjacent-duplicates-in-string
//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        //Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
    }

    /**
     * 思路：
     * 使用栈来保存数据，每遇到一个一个字符，判断是否跟栈顶元素相同，相同则同时消去，否则入栈
     * 最终将栈中元素输出即可
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : S.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == c) {
                deque.pollLast();
            } else {
                deque.addLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.removeFirst());
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}