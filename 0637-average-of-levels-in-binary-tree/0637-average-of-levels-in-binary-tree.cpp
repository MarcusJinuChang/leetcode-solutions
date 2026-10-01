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
    vector<double> arr;
    vector<double> cnt;

    vector<double> averageOfLevels(TreeNode* root) {
        helper(root);
        
        for (size_t i = 0; i < arr.size(); i++) {
            arr[i] /= cnt[i];
        }

        return arr;
    }

    void helper(TreeNode* n, int level = 0) {
        if (!n) return;
        if (arr.size() == level) { arr.push_back(n->val); cnt.push_back(1); }
        else { arr.at(level) += n->val; cnt.at(level)++; }

        helper(n->left, level + 1);
        helper(n->right, level + 1);
    }
};