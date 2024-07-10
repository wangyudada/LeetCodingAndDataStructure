package month4.day2;

import month2.day16.ListNode;

public class Demo {
    public static void main(String[] args) {
        ListNode l6 = new ListNode(2);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode partition = new Solution().partition(l1, 3);
        System.out.println();
    }
}
