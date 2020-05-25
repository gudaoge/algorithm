/*
[6]Z 字形变换
zigzag-conversion
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }

    /**
     * 通常解法：
     * 模拟执行步骤
     * 初始化n个列表
     * 依次将字符串的字符放入对应列表
     * 再将多个列表的字符合并
     *
     * 数学解法：
     * 根据条件可以直接计算出每个字符对应的位置
     * 假设字符串总长度为s，行数为n
     *
     * 0     6       12       s%(2n-2)==0
     * 1   5 7    11 13    17 s%(2n-2)==1             s%(2n-2)==5
     * 2 4   8 10    14 16    s%(2n-2)==2 s%(2n-2)==4
     * 3     9       15       s%(2n-2)==3
     *
     * 即以重复的一段图形来看
     * 这个图形最多含有n+n-2个数字
     * 第1行有1个数字：s%(2n-2)==0
     * 第2行有2个数字：s%(2n-2)==1 s%(2n-2)==2n-2-1
     * 第3行有2个数字：s%(2n-2)==2 s%(2n-2)==2n-2-2
     * 第4行有2个数字：s%(2n-2)==3 s%(2n-2)==2n-2-3
     * 第n-1行2个数字 s%(2n-2)==n-1-1 s%(2n-2)==2n-2-(n-1)
     * 第n行有1个数字：s%(2n-2)==n-1
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        //1行没有意义 直接返回
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //重复图形的长度
        int mod = numRows * 2 - 2;

        //每次取一行
        for (int i = 0; i < numRows; i++) {
            //每次到一个重复图形的开始位置
            for (int j = 0; j + i < s.length(); j = j + mod) {
                stringBuilder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && (j + mod - i) < s.length()) {
                    stringBuilder.append(s.charAt(j + mod - i));
                }
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}