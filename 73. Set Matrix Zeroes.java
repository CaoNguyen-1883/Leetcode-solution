class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean[m];
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    rows[j] = true;
                    cols[i] = true;
                }
            }
        }

        for(int i = 0; i  < rows.length; ++i){
            if(rows[i] == true){
                for(int j = 0; j < m; ++j){
                    matrix[j][i] = 0;
                }
            }
        }
        
        for(int i = 0; i  < cols.length; ++i){
            if(cols[i] == true){
                for(int j = 0; j < n; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}