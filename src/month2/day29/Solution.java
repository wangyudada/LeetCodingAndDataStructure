package month2.day29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {

    HashMap<Integer, List<Integer>> map;
    Random random;

    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> integers = map.get(target);
        return integers.get(random.nextInt(integers.size()));
    }
}
