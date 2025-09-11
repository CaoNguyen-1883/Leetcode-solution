public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        int result = 0;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);

        while (absDividend >= absDivisor) { 
            int shift = 0;
            while(absDividend >= (absDivisor << shift)){
                shift++;
            }

            result += (1 << (shift - 1));

            absDividend -= absDivisor << (shift - 1);
        }

        return sign == -1 ? -result : result; 
    }
}

// 1001

// 0010

// 