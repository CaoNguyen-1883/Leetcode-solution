
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i <= numRows; ++i){
            Integer[] l = new Integer[i];
            Arrays.fill(l,  1);
            res.add(Arrays.asList(l));
        }

        for (int i = 2; i < numRows; ++i)
            for (int j = 1; j < res.get(i).size() - 1; ++j)
                res.get(i).set(j, res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        return res;
    }
}