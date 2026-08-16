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
    ListNode* partition(ListNode* head, int x) 
    {
        ListNode dummy(-1);
        ListNode* nextHead = &dummy;
        ListNode* trav = nextHead;

        ListNode* curr = head;
        
        ListNode orgDummy(-1);
        orgDummy.next = head;
        ListNode* prev = &orgDummy;
        while(curr)
        {
            
            if(curr->val >= x)
            {
              //  cout<<"curr->val:"<<curr->val<<endl;
             //   cout<<"prev->val:"<<prev->val<<endl;
                prev->next = curr->next;
                trav->next = curr;
                curr->next = nullptr;
                trav = trav->next;
                curr = prev->next;
            }
            else
            {
                 prev = curr;
                curr = curr->next;
               
            }
            
        }
        prev->next = nextHead->next;
        return  orgDummy.next;
        
    }
};