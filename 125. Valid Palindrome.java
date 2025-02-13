class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            char cLeft = s.charAt(left);    
            char cRight = s.charAt(right);

            if(!Character.isAlphabetic(cLeft) && !Character.isDigit(cLeft)) ++left;
            else if(!Character.isAlphabetic(cRight) && !Character.isDigit(cRight)) --right;
            else if(Character.compare(Character.toLowerCase(cLeft), Character.toLowerCase(cRight)) == 0) {
                ++left;
                --right;
            } else{
                return false;
            }
        }

        return true;
    }
}