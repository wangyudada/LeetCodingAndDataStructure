package month3.day16;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = new Solution().permuteUnique(nums);
        System.out.println(list);
    }
}
