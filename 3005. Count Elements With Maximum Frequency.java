class Solution {
    public int maxFrequencyElements(int[] nums) {
        byte []freq = new byte[101];
        int max = 0, res = 0;
        for(int num : nums){
            byte curr = ++freq[num];
            if(curr > max){
                max = curr;
                res = curr;
            } else if(curr == max){
                res += curr;
            }
        }



        return res;
    }   
}