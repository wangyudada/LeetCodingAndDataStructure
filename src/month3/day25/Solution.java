package month3.day25;

import month2.day16.ListNode;

public class Solution {
    /**
     * https://leetcode.cn/problems/remove-linked-list-elements/submissions/541762940/
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode ans = new ListNode(-1, head);
        ListNode pre = ans;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return ans.next;
    }
}
