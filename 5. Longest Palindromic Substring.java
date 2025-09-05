class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        for(int i = 0; i < n;){
            int l = i, r = i;

            while(r < n - 1 && s.charAt(r) == s.charAt(r + 1)) ++r;
            i = r + 1;

            while(r < n - 1 && l > 0 && s.charAt(l - 1) == s.charAt(r + 1)){
                ++r;
                --l;
            }

            if(ans.length() < r - l + 1){
                ans = s.substring(l, r + 1);
            }
        }


        return ans;
    }

}