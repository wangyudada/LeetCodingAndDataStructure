package month2.day19;

public class Test {
    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] abcdefghijklmnopqrstuvwxyzs = Solution.numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
        for (int i : abcdefghijklmnopqrstuvwxyzs) {
            System.out.println(i);
        }
    }
}
