package month3.day12;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int[] can = {2, 3, 6, 7};
        List<List<Integer>> list = new Solution().combinationSum(can, 7);
        System.out.println(list);
    }
}
