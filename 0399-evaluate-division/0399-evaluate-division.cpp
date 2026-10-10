#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        for (int i = 0; i < equations.size(); i++) {
            const string& a = equations[i][0];
            const string& b = equations[i][1];
            double val = values[i];
            umap[a][b] = val;
            umap[b][a] = 1.0 / val;
        }

        vector<double> result;
        for (vector<string>& v : queries) {
            unordered_set<string> seen;
            result.push_back(dfs(v[0], v[1], seen));
        }
        return result;
    }

private:
    unordered_map<string, unordered_map<string, double>> umap;

    // Returns the product of edge weights from a to b, or -1.0 if no path exists.
    double dfs(const string& a, const string& b, unordered_set<string> seen) {
        if (!umap.count(a) || !umap.count(b)) return -1.0;
        if (a == b) return 1.0;
        if (seen.count(a)) return -1.0;

        seen.insert(a);
        for (auto& [c, w] : umap[a]) {
            double d = dfs(c, b, seen);
            if (d != -1.0) return w * d;
        }
        return -1.0;
    }
};