class Solution {
    public int compress(char[] chars) {
        int res = 0, n = chars.length;
        int i = 0;

        while(i < n){
            int j = i + 1;
            while(j < n && chars[i] == chars[j]) ++j;
            chars[res++] = chars[i];
            if(j - i > 1){
                int x = j - i;
                int l = res;
                while(x > 0){
                    int num = x%10;
                    chars[res++] = (char)(num + '0');
                    x /= 10;
                }
                int r = res - 1;
                while(l < r){
                    char temp = chars[l];
                    chars[l++] = chars[r];
                    chars[r--] = temp;
                }
            }
            i = j;
        }

        return res;
    }
}