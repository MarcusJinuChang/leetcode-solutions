class Solution {
public:
    int rows, cols;

    void solve(vector<vector<char>>& board) {
        if (board.empty()) return;
        rows = board.size();
        cols = board[0].size();

        // Mark all O's connected to border as safe
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && 
                    board[r][c] == 'O') {
                    dfs(board, r, c);
                }
            }
        }

        // Flip all unmarked O's to X
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'S') board[r][c] = 'O'; // Restore safe O's
            }
        }
    }

private:
    void dfs(vector<vector<char>>& board, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') return;
        board[r][c] = 'S'; // Mark as safe
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
};