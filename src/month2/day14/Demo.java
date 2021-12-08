package month2.day14;

import java.awt.*;
import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @author WangYu
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Demo {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> occ = new HashSet<>();
        int n = s.length();
        int left = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while ((left + 1 < n) && !occ.contains(s.charAt(left + 1))) {
                occ.add(s.charAt(left + 1));
                left++;
            }
            ans = Math.max(ans, left - i + 1);
        }
        return ans;
    }
}
