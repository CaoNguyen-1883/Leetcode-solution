class Solution {
    public int romanToInt(String s) {
        int sum = 0;

        int [] dist = new int[128];
        dist['I'] = 1;
        dist['V'] = 5;
        dist['X'] = 10;
        dist['L'] = 50;
        dist['C'] = 100;
        dist['D'] = 500;
        dist['M'] = 1000;

        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int curr = dist[c];
            if(curr < prev){
                sum -= curr;
            } else{
                sum += curr;
            }
            prev = curr;
        }

        return sum;
    }
}