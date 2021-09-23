package month1.day29;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] ints = {4, 6, 7, 7};
        Demo demo = new Demo();
        List<List<Integer>> subsequences = demo.findSubsequences(ints);
        System.out.println(subsequences);
    }
}
