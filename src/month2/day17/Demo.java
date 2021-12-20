package month2.day17;

import month2.day9list.List;

import javax.sound.midi.MidiFileFormat;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Demo {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoList(ans, lists[i]);
        }
        return ans;
    }


    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null){
            return list1 != null ? list1: list2;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = list1, bPtr = list2;
        while (aPtr!=null&&bPtr!=null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }
            else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
