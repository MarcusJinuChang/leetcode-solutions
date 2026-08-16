/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr) return head;

        int cnt = 1;
        ListNode* cur = head;

        while (cur->next != nullptr) {
            cnt++;
            cur = cur->next;
        }

        ListNode* endnode = cur;
        cur = head;

        k = k % cnt;
        if (k == 0) return head;
        int n = cnt - k - 1;

        for (size_t i = 0; i < n; i++) {
            cur = cur->next;
        }

        ListNode* newhead = cur->next;
        cur->next = nullptr;
        endnode->next = head;

        return newhead;
    }
};