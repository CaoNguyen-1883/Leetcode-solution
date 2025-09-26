import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> restoreIpAddresses(final String s) {
    List<String> res = new ArrayList<>();
    dfs(s, res, new ArrayList<>(), 0);
    return res;
  }

  public void dfs(String s, List<String> res, List<String> path, int start){
    if(path.size() == 4 && start == s.length()){
        res.add(String.join(".", path));
        return;       
    }
    
    if(path.size() == 4 || start == s.length()) return;

    for(int length = 1; length <= 3; ++length){
        if(start + length > s.length()) return;

        if(length > 1 && s.charAt(start) == '0') return;

        String num = s.substring(start, start + length);

        if(Integer.parseInt(num) > 255) return;

        path.add(num);
        dfs(s, res, path, start + length);
        path.removeLast();

    }
  }

}
