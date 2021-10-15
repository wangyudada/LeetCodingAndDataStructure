package month2.day8;

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = demo.maxSubArray(nums);
        System.out.println(i);
    }
}
