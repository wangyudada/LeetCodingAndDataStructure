package month2.day19;

import java.util.HashMap;

/**
 * 806. 写字符串需要的行数
 *
 * @author WangYu
 * @date 2022/4/12
 */
public class Solution {
    public static int[] numberOfLines(int[] widths, String s) {
        int[] voInt = new int[2];
        int size = 0;
        int row = 1;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                int value = widths[s.charAt(i) - 'a'];
                hashMap.put(s.charAt(i), value);
                if (value + size > 100) {
                    row++;
                    size = value;
                } else {
                    size += value;
                }
            } else {
                int value = hashMap.get(s.charAt(i));
                if ((size + value) > 100) {
                    row++;
                    size = value;
                } else {
                    size += value;
                }
            }
        }
        voInt[0] = row;
        voInt[1] = size;
        return voInt;
    }
}
