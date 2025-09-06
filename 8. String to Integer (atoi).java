class Solution {
    public int myAtoi(String s) {
        if(s.isEmpty()) return 0;

        int i = 0;
        char[] str = s.toCharArray();
        int n = str.length;

        while(i < n && str[i] == ' ') i++;

        int sign = -1;

        if(i == n) return 0;

        if(str[i] == '-' || str[i] == '+'){
            if(str[i] == '-') sign = 1;
            i++;
        }

        int num = 0;
        while(i < n && Character.isDigit(str[i])){
            int digit =  str[i] - '0';
           
            if(num > (Integer.MAX_VALUE - digit) / 10){
                return sign == -1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num*10 + digit;

            i++;
        }

        return num*sign;
    }
}