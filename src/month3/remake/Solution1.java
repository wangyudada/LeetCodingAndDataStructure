package month3.remake;

import month2.day16.ListNode;

public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode firstNode;
        ListNode secondNode;
        ListNode temp;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            firstNode.next = temp;
            secondNode.next = firstNode;
            cur = firstNode;
        }
        return dummyNode.next;
    }
}
