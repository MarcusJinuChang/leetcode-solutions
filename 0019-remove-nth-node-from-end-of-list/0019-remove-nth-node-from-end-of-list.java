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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode dummy = new ListNode(-1, head);

        ListNode save = dummy;
        ListNode node = head;

        for (int i = 0; i < n - 1; i++) {
            node = node.next;
        }

        while (node.next != null) {
            node = node.next;
            save = save.next;
        }

        save.next = save.next.next;

        if (save.val == -1)
            return save.next;
        return head;
    }
}