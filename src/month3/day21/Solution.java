package month3.day21;

public class Solution {

    /**
     * https://leetcode.cn/problems/squares-of-a-sorted-array/
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (Math.abs(nums[i]) >Math.abs(nums[j])) {
                int num = nums[i];
                result[k--] = num * num;
                i++;
            } else {
                int num = nums[j];
                result[k--] = num * num;
                j--;
            }
        }
        return result;
    }
}
