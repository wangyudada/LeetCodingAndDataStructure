package month3.day1;

public class Demo {
    public static void main(String[] args) {
        int[] ints = {2,10,7,5,4,1,8,6};
        Solution solution = new Solution();
        int i = solution.minimumDeletions(ints);
        System.out.println(i);
    }
}
