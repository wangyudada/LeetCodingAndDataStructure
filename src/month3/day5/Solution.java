package month3.day5;
public class Solution {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * https://leetcode.cn/problems/longest-palindromic-substring/description/
     */
    public String longestPalindrome(String s){
        if(s == null || s.isEmpty()){
            return "";
        }
        int left = 0;
        int right = 0;
        int length = 1;
        int maxStart = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i-1;
            right = i+1;
            while (left >=0 && s.charAt(left)==s.charAt(i)){
                left--;
                length++;
            }
            while (right<=s.length() && s.charAt(right)==s.charAt(i)){
                right++;
                length++;
            }
            while (right<=s.length() && left>= 0 && s.charAt(right)==s.charAt(left)){
                left--;
                right++;
                length += 2;
            }
            if (length >= maxLen){
                maxLen = length;
                maxStart = left;
            }
            length =1;
        }
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }
}
