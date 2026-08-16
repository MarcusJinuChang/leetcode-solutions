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
#include <vector>
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (head == nullptr || head->next == nullptr)
            return head;

        std::vector<ListNode*> low;
        std::vector<ListNode*> high;

        ListNode* n = head;

        while (n != nullptr) {
            if (n->val < x)
                low.push_back(n);
            else
                high.push_back(n);

            n = n->next;
        }

        if (!high.empty()) {
            for (size_t i = 0; i < high.size() - 1; i++) {
                high[i]->next = high[i + 1];
            }
            high[high.size() - 1]->next = nullptr;
        }

        if (!low.empty()) {
            for (size_t i = 0; i < low.size() - 1; i++) {
                low[i]->next = low[i + 1];
            }
            low[low.size() - 1]->next = !high.empty() ? high[0] : nullptr;
        } else {
            return high[0];
        }

        head = low[0];
        return head;
    }
};