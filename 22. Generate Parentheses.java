'import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        solve(res, new StringBuilder(), n, n);
    
        return res;
    }

    public void solve(List<String> res, StringBuilder sb, int l, int r){
        if(l == 0 && r == 0){
            res.add(sb.toString());
            return;
        }

        if(l > 0){
            sb.append('(');
            solve(res, sb, l - 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(l < r){
            sb.append(')');
            solve(res, sb, l, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

//,,, ()