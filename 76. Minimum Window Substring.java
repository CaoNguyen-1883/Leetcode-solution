class Solution {
    public String minWindow(String s, String t) {
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();

        int a[] = new int[128];
        int n = s.length();
        int m = t.length();
        int begin = -1;
        int offset = n + 1;

        for(char c : tArray) ++a[c];

        for(int l = 0, r = 0; r < n; ++r){
            --a[sArray[r]];
            if(a[sArray[r]] >= 0) --m;

            while(m == 0){
                if(r - l + 1 < offset){
                    begin = l;
                    offset = r - l + 1; 
                }
                //++a[sArray[l]];
                if(++a[sArray[l++]] > 0){
                    ++m;
                }
            }
        }

        return begin == -1 ? "" : s.substring(begin, begin + offset + 1);
    }
}