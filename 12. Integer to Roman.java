
import java.util.ArrayList;
import java.util.List;

class Solution {
    private Pair[] syms;

    private class Pair {
        public int key;
        public String value;

        public Pair(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public Solution(){
        syms = new Pair[13];
        syms[0] = new Pair(1000, "M");
        syms[1] = new Pair(900, "CM");
        syms[2] = new Pair(500, "D");
        syms[3] = new Pair(400, "CD");
        syms[4] = new Pair(100, "C");
        syms[5] = new Pair(90, "XC");
        syms[6] = new Pair(50, "L");
        syms[7] = new Pair(40, "XL");
        syms[8] = new Pair(10, "X");
        syms[9] = new Pair(9, "IX");
        syms[10] = new Pair(5, "V");
        syms[11] = new Pair(4, "IV");
        syms[12] = new Pair(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

      
        for(Pair p : this.syms){
            if(num <= 0) break;

            while(num >= p.key){
                num -= p.key;
                sb.append(p.value);
            }
        }


        return sb.toString();
    }
}