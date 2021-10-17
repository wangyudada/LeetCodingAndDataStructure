package month2.day8;

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}};
        int i = demo.minPathSum(nums);
        System.out.println(i);
    }
}
