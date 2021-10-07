package month2.day5;

public class Test {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Demo demo = new Demo();
        int i = demo.uniquePathsWithObstacles(nums);
        System.out.println(i);
    }
}
