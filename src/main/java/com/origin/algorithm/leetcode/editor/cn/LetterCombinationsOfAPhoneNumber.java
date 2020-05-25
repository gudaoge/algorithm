/*
[17]电话号码的字母组合
letter-combinations-of-a-phone-number
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    /**
     * 类似树的深度遍历
     * 采用递归的方式，遍历到叶子节点后将路径加入结果集
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Character, String> dic = new HashMap<Character, String>() {
        {
           put('2', "abc");
           put('3', "def");
           put('4', "ghi");
           put('5', "jkl");
           put('6', "mno");
           put('7', "pqrs");
           put('8', "tuv");
           put('9', "wxyz");
        }
    };

    private String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Stack<Character> path = new Stack<>();
        List<String> result = new ArrayList<>();

        combine(path, 0, result);
        return result;
    }

    private void combine(Stack<Character> path, int index, List<String> result) {
        if (index >= digits.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : path) {
                stringBuilder.append(character);
            }
            result.add(stringBuilder.toString());
            return;
        }
        for (char x : dic.get(digits.charAt(index)).toCharArray()) {
            path.push(x);
            combine(path, index + 1, result);
            path.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}