import java.util.Arrays;

class Solution {

    public List<Integer> getRow(int rowIndex) {
        Integer []res = new Integer[rowIndex + 1];  
        Arrays.fill(res, 1);

        for(int i = 2; i < rowIndex + 1; i++){
            for(int j = 1; j < i; j++){
                res[i - j] += res[i - j - 1];
            }
        }
        
        return Arrays.asList(res);
    }
}