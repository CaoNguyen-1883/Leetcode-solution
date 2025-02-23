class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0, n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i : s){
            if(res < n && g[res] <= i) ++res;
        }

        return res;
    }
}