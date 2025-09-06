class Solution {
    public int reverse(int x) {
        int sum = 0;

        while(x != 0){
            if(sum < Integer.MIN_VALUE/10 || sum > Integer.MAX_VALUE/10) return 0;
            int lastDigit = x % 10;
            sum = sum*10 + lastDigit;
            x /= 10;
        }

        return sum;
    }
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return x == this.reverse(x);
    }
}