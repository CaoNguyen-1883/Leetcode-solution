#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int totalNQueens(int n) {
        int res = 0;

        vector<string> board(n, string(n, '.'));
        vector<bool> cols(n);
        vector<bool> diag1(2*n - 1);
        vector<bool> diag2(2*n - 1);

        solve(res, board, cols, diag1, diag2, n, 0);
        return res;
    }

    void solve(int& res, vector<string>& board, vector<bool>& cols, vector<bool>& diag1, vector<bool>& diag2, int n, int i){
        if(i == n){
            ++res;
            for(auto a : board){
                cout << a << endl;
            }
            cout << endl;
            return;
        }

        for(int j = 0; j < n; ++j){
            if(cols[j] || diag1[i + j] || diag2[j - i + n - 1]) continue;

            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
            board[i][j] = 'Q';

            solve(res, board, cols, diag1, diag2, n, i + 1);

            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
            board[i][j] = '.';
        }
    }
};

int main(){
    Solution s;
    int n;
    cout <<"nhap n o: "; 
    cin >> n;
    cout << s.totalNQueens(n) << endl;
}