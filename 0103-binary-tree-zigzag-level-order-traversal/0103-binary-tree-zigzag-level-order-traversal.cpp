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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        helperleft(root);
        helperright(root);
        return ans;
    }

    void helperleft(TreeNode* node, int level = 0) {
        if (!node)
            return;

        if (ans.size() == level) {
            vector<int> a;
            ans.push_back(a);
        }

        if (level % 2 == 0) {
            ans.at(level).push_back(node->val);
        }

        helperleft(node->left, level + 1);
        helperleft(node->right, level + 1);
    }

    void helperright(TreeNode* node, int level = 0) {
        if (!node)
            return;

        if (level % 2 == 1) {
            ans.at(level).push_back(node->val);
        }

        helperright(node->right, level + 1);
        helperright(node->left, level + 1);
    }

private:
    vector<vector<int>> ans;
};