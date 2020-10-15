/*
[844]比较含退格的字符串
backspace-string-compare
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针

*/
package com.origin.algorithm.leetcode.editor.cn;
public class P844BackspaceStringCompare {
    public static void main(String[] args) {
        //Solution solution = new P844BackspaceStringCompare().new Solution();
    }

    /**
     * 思路：
     * 解法1：
     * 暴力破解，将包含退格的字符串转换为实际的字符串在进行比较
     *
     * 解法2：
     * 若从前往后比较，会受到退格的影响，因此采用从后往前比较
     * 遇到退格则记录退格次数，然后在非退格字符左移次数
     * 所以采用双指针法
     * 时间复杂度O(N) 空间复杂度O(1)
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {

        int s = S.length() - 1;
        int t = T.length() - 1;

        int sBack = 0;
        int tBack = 0;

        while (s >= 0 && t >= 0) {
            while (s >= 0) {
                if (S.charAt(s) == '#') {
                    sBack++;
                    s--;
                } else {
                    if (sBack == 0) {
                       break;
                    }
                    sBack--;
                    s--;
                }
            }
            while (t >= 0) {
                if (T.charAt(t) == '#') {
                    tBack++;
                    t--;
                } else {
                    if (tBack == 0) {
                        break;
                    }
                    tBack--;
                    t--;
                }
            }

            //都到了真实字符
            if (s >= 0 && t >= 0 ) {
                if (S.charAt(s) != T.charAt(t)) {
                    return false;
                }
                s--;
                t--;
            }

        }
        //对于剩余的字符串，因为全部退格后可能为空字符串，所以继续处理
        while (s >= 0) {
            if (S.charAt(s) == '#') {
                sBack++;
                s--;
            } else {
                if (sBack == 0) {
                    break;
                }
                sBack--;
                s--;
            }
        }
        while (t >= 0) {
            if (T.charAt(t) == '#') {
                tBack++;
                t--;
            } else {
                if (tBack == 0) {
                    break;
                }
                tBack--;
                t--;
            }
        }
        //都到了末尾
        if (s < 0 && t < 0) {
            return true;
        }
        //只有一个到了末尾
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}