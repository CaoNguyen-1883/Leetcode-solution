class Solution {
    private int X = 0;
    // public int finalValueAfterOperations(String[] operations) {
        
    //     for(String s : operations){
    //         if(s.substring(0, 2).equals("--")) --X;
    //         else if(s.substring(0, 2).equals("++")) ++X;
    //         else if(s.substring(1, 3).equals("--")) X--;
    //         else if(s.substring(1, 3).equals("++")) X++;
    //     }

    //     return X;
    // }
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;  // start with X = 0
        
        for (String op : operations) {
            if (op.contains("+")) {
                X++;   
            } else {
                X--;  
            }
        }
        
        return X;
    }
}