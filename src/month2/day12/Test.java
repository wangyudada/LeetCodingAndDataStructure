package month2.day12;

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = demo.maxSubArray(ints);
        System.out.println(i);
    }
}
