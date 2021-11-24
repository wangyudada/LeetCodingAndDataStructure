package month2.day13;

import java.util.HashMap;

/**
 * 423. 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 * <p>
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * @author WangYu
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 */
public class Demo {
    public String originalDigits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int[] nums = new int[10];
        nums[0] = map.getOrDefault('z', 0);
        nums[2] = map.getOrDefault('w', 0);
        nums[6] = map.getOrDefault('x', 0);
        nums[4] = map.getOrDefault('u', 0);
        nums[8] = map.getOrDefault('g', 0);

        nums[5] = map.getOrDefault('f', 0) - nums[4];
        nums[3] = map.getOrDefault('h', 0) - nums[8];
        nums[7] = map.getOrDefault('s', 0) - nums[6];

        nums[1] = map.getOrDefault('o', 0) - nums[0] - nums[2] - nums[4];
        nums[9] = map.getOrDefault('i', 0) - nums[5] - nums[6] - nums[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }
}
