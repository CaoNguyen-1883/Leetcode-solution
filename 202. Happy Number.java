public Solution{
    public static boolean isHappy(int n){
        int slow = squareSum(n);
        int fast = squareSum(slow);

        while(slow != fast){
            slow = squareSum(slow);
            fast = squareSum( squareSum(fast));
        }

        return slow == 1;
    }
    public static int squareSum(int n){
        int sum = 0;

        while(n > 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }

        return sum;
    }
}