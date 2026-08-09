class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] alive = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count = 0;
                for(int r=-1;r<=1;r++){
                    for(int c = -1;c<=1;c++){
                        if(r==0 && c==0) continue;
                        int nr = i+r;
                        int nc = j+c;
                        if(nr>=0 && nc>=0 && nr<n && nc<m){
                            count += board[nr][nc];
                        }
                    }
                }
                if(board[i][j]==0 && count==3) alive[i][j] = true;
                else if(board[i][j]==1 && (count==2 || count==3)) alive[i][j] = true;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(alive[i][j]){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
}