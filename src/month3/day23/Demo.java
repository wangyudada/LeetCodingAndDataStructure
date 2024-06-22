package month3.day23;

public class Demo {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums = {1,2,3,4,5};
        int i = new Solution().minSubArrayLen(15, nums);
        System.out.println(i);
    }
}
