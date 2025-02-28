class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean sub[][] = new boolean[9][9];

        for(int i = 0 ; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char c = board[i][j];
                if(c != '.'){
                    int n = c - '0' - 1;
                    int idx = i/3 * 3 + j/3;
                    if(rows[i][n] == true || col[j][n] == true || sub[idx][n] == true) return false;

                    rows[i][n] = true;
                    col[j][n] = true;
                    sub[idx][n] = true;
                }
            }
        }
        return true;
    }
}