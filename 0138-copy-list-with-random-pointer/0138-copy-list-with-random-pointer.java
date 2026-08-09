class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        // First pass: create all copy nodes (val only), keyed by original node
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: wire up next and random using the map
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = curr.next != null ? map.get(curr.next) : null;
            copy.random = curr.random != null ? map.get(curr.random) : null;
            curr = curr.next;
        }

        return map.get(head);
    }
}