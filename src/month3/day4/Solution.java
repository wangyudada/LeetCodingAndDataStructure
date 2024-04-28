package month3.day4;

import month2.day16.ListNode;

import java.util.HashMap;


/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode test = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (test.next != null) {
            map.put(test.val, map.getOrDefault(test.val, 0) + 1);
            test = test.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            while (map.containsKey(pre.next.val) && map.get(pre.next.val) > 1) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return dummy.next;
    }

    /**
     *给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     *  的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcbcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result = -1;
        int index = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                index = Math.max(index,map.get(chars[i])+1);
            }
            map.put(chars[i],i);
            result = Math.max(i-index+1,result);
        }
        return result;
    }
}