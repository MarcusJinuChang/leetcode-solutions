/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        helper(root);
        return ans;
    }

    void helper(TreeNode* node, int level = 0) {
        if (!node)
            return;
        if (ans.size() == level) {
            vector<int> a;
            ans.push_back(a);
            ans.at(level).push_back(node->val);
        } else
            ans.at(level).push_back(node->val);

        helper(node->left, level + 1);
        helper(node->right, level + 1);
    }

private:
    vector<vector<int>> ans;
};