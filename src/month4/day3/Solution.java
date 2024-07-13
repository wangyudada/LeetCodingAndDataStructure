package month4.day3;

import month2.day16.ListNode;

public class Solution {
    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/description/
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode last = dummyHead;
        for (int i = 0; i < right - 1; i++) {
            last = last.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = last.next;
        pre.next = null;
        last.next = null;
        reverseList(leftNode);
        pre.next = last;
        leftNode.next = cur;
        return dummyHead.next;
    }

    private void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
