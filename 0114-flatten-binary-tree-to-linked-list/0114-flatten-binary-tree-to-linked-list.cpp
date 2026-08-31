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
    void flatten(TreeNode* root) {
        // base
        if (root == nullptr) return;
        
        // postorder
        if (root->right != nullptr and (root->right->left != nullptr or root->right->right != nullptr)) {
            flatten(root->right);
        }
        if (root->left != nullptr and (root->left->left != nullptr or root->left->right != nullptr)) {
            flatten(root->left);
        }

        // cases
        if (root->left != nullptr and root->right == nullptr) {
            root->right = root->left;
            root->left = nullptr;
        }

        else if (root->left == nullptr and root->right != nullptr) {
            // nothing
            return;
        }

        else if (root->left != nullptr and root->right != nullptr) {
            TreeNode* n = root->left;
            
            while (n->right != nullptr) {
                n = n->right;
            }

            n->right = root->right;

            root->right = root->left;
            root->left = nullptr;
        }

        else {
            // nothing, shouldn't be possible
            return;
        }

    }
};