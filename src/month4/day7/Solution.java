package month4.day7;

import java.util.HashMap;

public class Solution {

    /**
     * https://leetcode.cn/problems/4sum-ii/
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                ans += map.getOrDefault(-i - j, 0);
            }
        }
        return ans;
    }
}
