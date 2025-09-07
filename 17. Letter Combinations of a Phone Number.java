import java.util.ArrayList;
import java.util.List;

class Solution {
    private char[][] board;

    public Solution(){
        board = new char[128][];
        board['2'] = new char[]{'a', 'b', 'c'};
        board['3'] = new char[]{'d', 'e', 'f'};
        board['4'] = new char[]{'g', 'h', 'i'};
        board['5'] = new char[]{'j', 'k', 'l'};
        board['6'] = new char[]{'m', 'n', 'o'};
        board['7'] = new char[]{'p', 'q', 'r', 's'};
        board['8'] = new char[]{'t', 'u', 'v'};
        board['9'] = new char[]{'w', 'x', 'y', 'z'};
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        
        List<String> res = new ArrayList<>();

        solve(res, digits, new StringBuilder(), 0);

        return res;
    }

    public void solve(List<String> res, String digits, StringBuilder str, int i) {
        if(i == digits.length()){
            res.add(str.toString());
            return;
        }

        char[] letter = board[digits.charAt(i)];

        for(char c : letter){
            str.append(c);
            solve(res, digits, str, i + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}



class Solution2 {
    private char[][] board;

    public Solution2(){
        board = new char[128][];
        board['2'] = new char[]{'a', 'b', 'c'};
        board['3'] = new char[]{'d', 'e', 'f'};
        board['4'] = new char[]{'g', 'h', 'i'};
        board['5'] = new char[]{'j', 'k', 'l'};
        board['6'] = new char[]{'m', 'n', 'o'};
        board['7'] = new char[]{'p', 'q', 'r', 's'};
        board['8'] = new char[]{'t', 'u', 'v'};
        board['9'] = new char[]{'w', 'x', 'y', 'z'};
    }
}