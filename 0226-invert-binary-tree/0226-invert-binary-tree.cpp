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
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return root;

        invert(root);

        return root;
    }

    void invert(TreeNode* root) {
        TreeNode* temp = root->right;
        root->right = root->left;
        root->left = temp;

        if (root->left != nullptr) invert(root->left);
        if (root->right != nullptr) invert(root->right);
    }
};