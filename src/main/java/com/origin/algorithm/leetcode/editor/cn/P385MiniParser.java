/*
[385]迷你语法分析器
mini-parser
//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;

import com.origin.algorithm.leetcode.editor.cn.structure.NestedInteger;

import java.util.Stack;

public class P385MiniParser {
    public static void main(String[] args) {
        //Solution solution = new P385MiniParser().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
    /**
     * 思路：
     * 首先我们要区分数字，括号，逗号
     * 当遇到数字时，判断是不是在括号内，若在括号内，就添加到括号所属对象里
     * 当遇到[时，构建数组对象入栈，当遇到]时，数组对象出栈
     *
     */
    class Solution {
//    public NestedInteger deserialize(String s) {
//
//        Stack<NestedInteger> stack = new Stack<>();
//
//        int index = 0;
//
//        while (index < s.length()) {
//
//            char c = s.charAt(index);
//
//            //说明一个数组的开始
//            if (c == '[') {
//                NestedInteger integer = new NestedInteger();
//                if (!stack.isEmpty()) {
//                    stack.peek().add(integer);
//                }
//                stack.push(integer);
//                index++;
//                continue;
//            }
//            //说明数组结束
//            if (c == ']') {
//                NestedInteger integer = stack.pop();
//                if (stack.isEmpty()) {
//                    return integer;
//                }
//                index++;
//                continue;
//            }
//
//            if (c == ',') {
//                index++;
//                continue;
//            }
//            //开始解析数字
//            int end = index + 1;
//            while (end < s.length() && Character.isDigit(s.charAt(end))) {
//                end ++;
//            }
//            int number = Integer.parseInt(s.substring(index, end));
//
//            NestedInteger integer = new NestedInteger(number);
//
//            if (stack.isEmpty()) {
//                //不处于数组内，那结果肯定是单个数字
//                return integer;
//            } else {
//                //处于数组内
//                stack.peek().add(integer);
//            }
//            index = end;
//        }
//
//        return null;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}