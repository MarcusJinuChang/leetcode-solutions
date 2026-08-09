class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode start = head;
        ListNode prestart = null;

        ListNode curr = start;
        ListNode prev = prestart;
        ListNode next = curr.next;

        ListNode n = curr;

        while (start != null) {
            for (int i = 0; i < k; i++) {
                if (n == null)
                    return head;
                n = n.next;
            }

            for (int i = 0; i < k - 1; i++) {
                prev = curr;
                curr = next;
                next = curr.next;

                if (i == k - 2)
                    start.next = next;
                curr.next = prev;
            }

            if (prestart == null) {
                head = curr;
            } else {
                prestart.next = curr;
            }

            prestart = start;      // start is the tail of the group just reversed
            start = start.next;
            curr = start;
            prev = prestart;
            next = curr != null ? curr.next : null;
            n = curr;
        }

        return head;
    }
}