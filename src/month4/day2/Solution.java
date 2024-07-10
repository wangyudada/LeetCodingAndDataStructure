package month4.day2;

import month2.day16.ListNode;

public class Solution {
    /**
     * https://leetcode.cn/problems/partition-list/
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            int value = head.val;
            if (value >= x) {
                large.next = head;
                large = large.next;
            }
            if (value < x) {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
