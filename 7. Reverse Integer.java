// class Solution {
//     public int reverse(int x) {
//         long ans = 0;
//         boolean flag = x < 0 ? true : false;
//         long convert = x >= 0 ? x : -x;

//         while(convert > 0){
//             ans = ans * 10 + (convert % 10);
//             convert /= 10;
//         }

//         if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;

//         return (int)(flag ? -ans : ans);
//     }
// }

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
}