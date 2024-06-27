package month3.day28;

import month2.day16.ListNode;

public class Solution {
    /**
     * https://leetcode.cn/problems/swap-nodes-in-pairs/
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dummyHead.next;
    }
}
