package month3.day31;

import month2.day16.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;

        if (lenB > lenA) {
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        int gap = lenA - lenB;
        while (gap > 0) {
            gap--;
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
