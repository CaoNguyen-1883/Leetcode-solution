class Solution {
    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder(s.length() - 1);
        char arr[] = s.toCharArray();

        int fast = s.length() - 1;

        while(fast >= 0 && arr[fast] == ' ') --fast;

        int slow = fast;

        while(fast >= 0){

            while(fast >= 0 && (
                arr[fast] >= 'a' && arr[fast] <= 'z' ||
                arr[fast] >= 'A' && arr[fast] <= 'Z' ||
                arr[fast] >= '0' && arr[fast] <= '9'
            )) --fast;
            
            result.append(s.substring(fast + 1, slow + 1) + " ");

            while(fast >= 0 && s.charAt(fast) == ' ') --fast;

            slow = fast;
        }


        return result.toString().trim();
    }
}

