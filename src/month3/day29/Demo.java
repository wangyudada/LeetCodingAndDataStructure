package month3.day29;

import month2.day16.ListNode;

public class Demo {
    public static void main(String[] args) {
        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(1, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode listNode = new Solution().deleteDuplicates(l1);
        System.out.println();
    }
}
