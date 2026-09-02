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
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode* node, int num) {
        if (!node->left and !node->right) {
            sum += num*10 + node->val;
        } else {
            if (node->left) helper(node->left, num * 10 + node->val);
            if (node->right) helper(node->right, num * 10 + node->val);
        }
    }

private:
    int sum = 0;
};