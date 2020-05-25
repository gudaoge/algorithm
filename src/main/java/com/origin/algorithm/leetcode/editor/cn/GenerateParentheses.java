/*
[22]括号生成
generate-parentheses
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    /**
     * 暴力解法：
     * 每次从现有的括号集合中选择一个位置放入一对括号
     * 需要考虑结果去重
     *
     *
     * 排列组合解法：
     * 固定n个左括号，求右括号的插入方式
     * 例如：
     * （_（_（_（_
     * 若4组括号，则有四个空位，每个空位和前面空位的右括号之和不得超过左括号数量，即空位的位置，
     * 每个空位依次可以放：
     * [0,1]
     * [0,2]
     * [0,3]
     * [1,4]
     * 最后一个空位比较特殊,剩下的右括号都可以放到第四个空位
     * 采用排列组合方式的结果本身无重复，无需去重
     * 对于排列组合的实现 考虑采用递归形式的深度遍历
     *
     * 回溯法：
     * ？？？
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 剩余的右括号
         */
    private int remain;
        /**
         * 当前的路径
         * 即每个空位的右括号数量
         */
    private Stack<Integer> path = new Stack<>();

        /**
         * 符合条件的结果集
         */
    private List<String> result = new ArrayList<>();

        /**
         * 空位数
         */
    private int total;

    private int use = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        this.remain = n;
        this.total = n;

        generate(1);

        return result;
    }

    private void generate(int currentIndex) {
        if (currentIndex == total) {
            //到达最后一个空位时，将结果集保存
            //path中保存是的前n-1个空位的值
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer count : path) {
                stringBuilder.append("(");
                for (int x = 0; x < count; x++) {
                    stringBuilder.append(")");
                }
            }
            //打印最后一个空位
            stringBuilder.append("(");
            for (int x = 0; x < remain; x++) {
                //将剩余的右括号填充
                stringBuilder.append(")");
            }
            result.add(stringBuilder.toString());
            return;
        }
        //当前空位的可选值 最小值为0，最大值为（当前空位的所允许的值与剩余右括号的最小值）
        //其中，当前空位允许的值为当前空位+前面所有的空位的的右括号的值
        int option = Math.min(currentIndex - use, remain);
        for (int i = 0; i <= option; i++) {
            path.push(i);
            remain = remain - i;
            use = use + i;
            generate(currentIndex + 1);
            remain = remain + i;
            use = use - i;
            path.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}