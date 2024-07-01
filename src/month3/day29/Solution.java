package month3.day29;

import month2.day16.ListNode;

import java.util.HashSet;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = new ListNode(0, head);
        HashSet<Integer> exists = new HashSet<>();
        while (cur.next != null) {
            int value = cur.next.val;
            if (exists.contains(value)) {
                cur.next = cur.next.next;
                continue;
            }
            exists.add(value);
            cur = cur.next;
        }
        return head;
    }
}
