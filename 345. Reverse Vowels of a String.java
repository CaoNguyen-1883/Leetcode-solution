
import javax.print.DocFlavor;

class Solution {
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int left = 0, right = res.length - 1;
        boolean[] v = new boolean[128];
        v['a'] = true; 
        v['e'] = true; 
        v['i'] = true; 
        v['o'] = true; 
        v['u'] = true; 
        v['A'] = true; 
        v['E'] = true; 
        v['I'] = true; 
        v['O'] = true; 
        v['U'] = true;

        while(left < right){
            while(v[res[left]] != true && left < right) ++left;
            while(v[res[right]] != true && left < right) --right;

            char temp = res[left];
            res[left++] = res[right];
            res[right--] = temp;
        }


        return String.copyValueOf(res);
    }
}