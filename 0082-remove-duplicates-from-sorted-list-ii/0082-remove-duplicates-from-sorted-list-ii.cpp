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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;

        ListNode* a = new ListNode(-101, head);
        ListNode* b = head;
        ListNode* c = head->next;

        while (c != nullptr) {
            if (b->val == c->val) {
                while (c != nullptr and c->val == b->val) {
                    c = c->next;
                }

                a->next = c;
                b = c;
                if (c != nullptr) {
                    c = c->next;
                }

                if (a->val == -101) {
                    head = b;
                    a->next = b;
                }
            } else {
                a = a->next;
                b = b->next;
                c = c->next;
            }
        }
        
        return head;
    }
};