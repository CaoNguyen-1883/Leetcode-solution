import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        solve(res, new StringBuilder(), n*2);
    
        return res;
    }

    public void solve(List<String> res, char[] str, int i, int n){
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        solve(res, sb, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}