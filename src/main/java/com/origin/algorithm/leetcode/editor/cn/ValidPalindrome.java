/*
[125]验证回文串
valid-palindrome
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

*/
package com.origin.algorithm.leetcode.editor.cn;
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    /**
     * 回文字符串左右对称
     * 因此采用双指针从两端逼近，判断指针对应的规定字符是否相等
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //定位到满足规则的字符
            while (left < right && !fit(s.charAt(left))) {
                left++;
            }
            while (left < right && !fit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean fit(Character c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}