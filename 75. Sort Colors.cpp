
class Solution{
public:
    void sortColors(vector<int>& nums) {
        int a[3] = {0};
        for(int& x : nums){
            ++a[x];
        }
        int i = 0;
        int size = a[0];
        for(; i < size; ++i) nums[i] = 0;
       
        size += a[1];
        for(; i < size; ++i) nums[i] = 1;

        size += a[2];
        for(; i < size; ++i) nums[i] = 2;
    }
}