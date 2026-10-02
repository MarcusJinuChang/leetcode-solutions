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
 #include <algorithm>
class Solution {
public:
    vector<int> arr;

    int kthSmallest(TreeNode* root, int k) {
        helper(root);
        std::sort(arr.begin(), arr.end());
        return arr.at(k - 1);
    }

    void helper(TreeNode* n) {
        if (!n) return;
        arr.push_back(n->val);
        helper(n->left);
        helper(n->right);
    }
};