/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include <utility>

class Solution {
public:
    bool isValidBST(TreeNode* node, long minimum = LONG_MIN, long maximum = LONG_MAX) {
        if (!node) return true;

        if (!(node->val > minimum && node->val < maximum)) return false;

        return isValidBST(node->left, minimum, node->val) && isValidBST(node->right, node->val, maximum);
    }


};