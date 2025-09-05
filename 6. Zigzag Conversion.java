
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s; 
        StringBuilder sbd = new StringBuilder();
        List<Character>[] rows = new List[numRows];

        //Arrays.fill(rows, new ArrayList<>());
        for(int i = 0; i < numRows; ++i){
            rows[i] = new ArrayList<>();
        }

        int i = 0;
        int direction = -1;

        for(final char c : s.toCharArray()){
            rows[i].add(c);
            if(i == 0 || i == numRows - 1) direction *= -1;
            i += direction;
        }

        for(List<Character> row : rows){
            for(final char c : row){
                sbd.append(c);
            }
        }

        return sbd.toString();
    }
}