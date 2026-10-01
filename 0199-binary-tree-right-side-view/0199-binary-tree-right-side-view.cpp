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
    vector<int> ans;

    vector<int> rightSideView(TreeNode* root) {
        helper(root);
        return ans;
    }

    void helper(TreeNode* n, int level = 0) {
        if (n == nullptr) return;
        if (ans.size() == level) ans.push_back(n->val);
        helper(n->right, level + 1);
        helper(n->left, level + 1);
    }
};