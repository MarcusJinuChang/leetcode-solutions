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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;

        while (true) {
            int carry = 0;
            l1.val += l2.val;

            if (l1.val >= 10) {
                l1.val -= 10;
                carry++;
            }

            if (l1.next != null || l2.next != null || carry > 0) {
                l1.next = l1.next == null ? new ListNode(0) : l1.next;
                if (carry > 0) l1.next.val++;
                l1 = l1.next;
                
                l2.next = l2.next == null ? new ListNode(0) : l2.next;
                l2 = l2.next;
            } else {
                break;
            }
        }

        return res;
    }
}