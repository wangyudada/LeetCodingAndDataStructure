package month3.day30;

import month2.day16.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        n++;
        ListNode first = dummyNode;
        ListNode last = dummyNode;
        while (n != 0 && first != null) {
            first = first.next;
            n--;
        }
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        if (last.next != null) {
            last.next = last.next.next;
        }
        return dummyNode.next;
    }
}
