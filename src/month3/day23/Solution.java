package month3.day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * https://leetcode.cn/problems/2VG8Kg/
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = left; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * https://leetcode.cn/problems/repeated-dna-sequences/
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        char[] array = s.toCharArray();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (int i = 0; i + 10 <= array.length; i++) {
            String str = s.substring(i, i + 10);
            int count = cnt.getOrDefault(str, 0);
            if (count == 1) result.add(str);
            cnt.put(str, count + 1);
        }
        return result;
    }
}
