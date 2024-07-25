package month4.day6;

public class Demo {
    public static void main(String[] args) {

    }

    private void insertSort(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 1; i < length; i++) {
            int tempI = nums[i];
            for (j = i - 1; j > 0; j--) {
                int tempJ = nums[j];
                if (tempI > tempJ) {
                    break;
                } else {
                    nums[j + 1] = nums[j];
                }
            }
            nums[j + 1] = tempI;
        }
    }
}
