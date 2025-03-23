class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length;){
            int l = i, r = i;
            while(r < a.length - 1 && a[r] == a[r + 1]) ++r;
            
            i = r + 1;

            while(l > 0 && r < a.length - 1 && a[l - 1] == a[r + 1]){
                l--;
                r++;
            }
            if(res.length() < r - l + 1){
                res = s.substring(l, r + 1);
            }
        }

        return res;
    }
}