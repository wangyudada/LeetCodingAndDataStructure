package month3.day1;

class Solution {
    public int minimumDeletions(int[] nums) {
        int vo = 0;
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int maxPoint = 0;
        int minPoint = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[maxPoint]) {
                maxPoint = i;
            }
            if (nums[i] < nums[minPoint]) {
                minPoint = i;
            }
        }
        if (maxPoint < minPoint) {
            int temp = minPoint;
            minPoint = maxPoint;
            maxPoint = temp;
        }
        vo = Math.min(maxPoint + 1, length - minPoint);
        vo = Math.min(vo, minPoint + 1 + length - maxPoint);
        return vo;
    }
}