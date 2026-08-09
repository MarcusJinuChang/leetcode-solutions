class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        // row
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                if (set.contains(board[r][c])) {
                    System.out.println(r);
                    return false;
                }
                set.add(board[r][c]);
            }
            set.clear();
        }

        // col
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;

                if (set.contains(board[r][c])) {
                    System.out.println(c);
                    return false;
                }
                set.add(board[r][c]);
            }
            set.clear();
        }

        // box

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (board[r + 3*i][c + 3*j] == '.') continue;

                        if (set.contains(board[r + 3*i][c + 3*j])) {
                            System.out.println(i + " " + j);
                            return false;
                        }
                        set.add(board[r + 3*i][c + 3*j]);
                    }
                }
                set.clear();
            }
        }

        return true;
    }
}