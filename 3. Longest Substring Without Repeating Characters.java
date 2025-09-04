class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;

        char[] seq = s.toCharArray();
        int max = 0;

        int[] chars = new int[128];
        int j = 0;

        for(int i = 0; i < seq.length; i++){
            char c = seq[i];

            chars[c]++;
            
            while(chars[c] > 1){
                chars[seq[j]]--;
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;

    }
}

//abcazqhgfbcbb