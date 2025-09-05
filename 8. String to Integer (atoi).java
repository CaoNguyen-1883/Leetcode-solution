class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        int n = str.length;
        int i = 0;

        // Skip leading whitespace
        while (i < n && str[i] == ' ') i++;

        // Check if string is all whitespace
        if (i == n) return 0;

        // Handle sign
        int sign = 1;
        if (str[i] == '-' || str[i] == '+') {
            if(str[i] == '-') sign = -1;
            i++;
        }

        int num = 0;
        while (i < n && Character.isDigit(str[i])) {
            int digit = str[i] - '0';
            // Check for overflow before updating the number
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && digit > 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 - digit; // Build the number as negative to handle overflow correctly
            i++;
        }

        // Adjust the result based on the sign
        if (sign == 1) {
            if (num == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -num;
        }
        return num;
    }
}