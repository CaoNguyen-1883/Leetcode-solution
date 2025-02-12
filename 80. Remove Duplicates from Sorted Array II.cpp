
class Solution{
public:
    int removeDuplicates(vector<int>& nums) {
        // if (nums.empty()) return 0;


        // int slow = 0;
        // int fast;
        // int i = 0;

        // while(slow < nums.size()){  
        //     fast = slow + 1;
        //     while(nums[slow] == nums[fast] && fast < nums.size()) ++fast;

        //     if(fast - slow == 1){
        //         nums[i] = nums[slow];
        //         i += 1;
        //     } else{
        //         nums[i] = nums[slow];
        //         nums[i + 1] = nums[slow];
        //         i += 2;
        //     }

        //     slow = fast;
        // }

        if(nums.size() <= 2) return nums.size();

        int i = 2;

        for(int j = 2; j < nums.size(); ++j){
            if(nums[j] != nums[i - 2]){
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}