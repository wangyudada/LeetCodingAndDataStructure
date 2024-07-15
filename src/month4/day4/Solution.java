package month4.day4;

import month2.day16.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * https://leetcode.cn/problems/copy-list-with-random-pointer/
     *
     * @param head
     * @return
     */
    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while(cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }
}
