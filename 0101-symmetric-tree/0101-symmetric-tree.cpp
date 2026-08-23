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
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr or root->left == nullptr and root->right == nullptr) return true;
        if (root->left == nullptr or root->right == nullptr) return false;

        return comp(root->left, root->right);
    }

    bool comp(TreeNode* l, TreeNode* r) {
        if (r == nullptr and l == nullptr) return true;
        if (r == nullptr or l == nullptr) return false;

        return l->val == r->val and comp(l->left, r->right) and comp(l->right, r->left);
    }
};