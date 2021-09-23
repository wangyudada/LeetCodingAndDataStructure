package month1.day123;

class Solution {
    public static void main(String[] args) {
        System.out.println(dayOfYear("2020-11-03"));
    }

    public static int dayOfYear(String date) {
        int count = 0;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int a[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            a[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            count += a[i];
        }
        count = count + day;
        return count;
    }
}

