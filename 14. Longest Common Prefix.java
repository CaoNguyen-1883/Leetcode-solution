class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String lc = strs[0];
        
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            for(; j < lc.length() && j < strs[i].length(); j++){
                if(lc.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            lc = lc.substring(0, j);

        }

        return lc;
    }
}