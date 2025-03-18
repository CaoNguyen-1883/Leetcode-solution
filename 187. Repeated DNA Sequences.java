
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> seen = new HashSet<>();
        int n = s.length();

        for(int i = 0; i <= n - 10; ++i){
            String subStr = s.substring(i, i + 10);
            if(seen.contains(subStr)){
                res.add(subStr);
            }
            seen.add(subStr);
        }

        return new ArrayList<>(res);
    }
}