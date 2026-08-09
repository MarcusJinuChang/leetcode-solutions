/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }

        ListNode t = head;
        ListNode before = null;

        int pos = 1;

        while (t != null) {
            if (pos == left) {
                int times = right - left + 1;
                ListNode curr = t;
                ListNode prev = null;

                for (int i = 0; i < times; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                t.next = curr;
                if (before != null) {
                    before.next = prev;
                } else {
                    return prev;
                }
                break;

            } else {
                before = t;
                t = t.next;
                pos++;
            }
        }

        return head;
    }
}