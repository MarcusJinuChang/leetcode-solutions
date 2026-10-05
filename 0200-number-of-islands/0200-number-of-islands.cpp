#include <vector>
#include <algorithm>

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;
        
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        int cnt = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, visited, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

private:
    void dfs(vector<vector<char>>& grid, vector<vector<bool>>& visited, int r, int c) {
        if (r < 0 || r >= grid.size() || c < 0 || c >= grid[0].size() ||
            visited[r][c] || grid[r][c] != '1') return;
        
        visited[r][c] = true;
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r, c - 1);
        dfs(grid, visited, r, c + 1);
    }
};