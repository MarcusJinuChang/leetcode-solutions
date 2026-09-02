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
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) return false;

        if (target == -5001001) { target = targetSum; targetSum = 0; }

        if (root->left == nullptr and root->right == nullptr and root->val + targetSum == target) return true;



        return hasPathSum(root->left, targetSum + root->val) or hasPathSum(root->right, targetSum + root->val);

    }
private:
    int target = -5001001;
};