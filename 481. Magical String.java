class Solution {
    public int magicalString(int n) {
        int a[] = new int[n];
        a[0] = 1;
        a[1] = 2;

        for(int i = 1, j = 1; j < n; ++i, ++j){
            a[j] = (i & 1) == 1 ? 2 : 1;
            if(a[i] == 2 && ++j < n)
                a[j] = a[j - 1];
        }

        int res = 0;
        for(int i : a)
            if(i == 1) ++res;
        
        return res;
    }
}