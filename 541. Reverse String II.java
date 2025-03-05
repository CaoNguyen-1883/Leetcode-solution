

class Solution {
    public String reverseStr(String s, int k) {
        char str[] = s.toCharArray();
        int n = str.length;
        for(int i = 0; i < n ; i += 2*k){
            int l = i;
            int r = Math.min(i + k - 1, n - 1);

            while(l < r){
                char temp = str[l];
                str[l++] = str[r];
                str[r--] = temp;
            }
        }

        return String.copyValueOf(str);
    }
}