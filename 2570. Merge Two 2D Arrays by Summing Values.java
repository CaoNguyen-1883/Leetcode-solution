class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] arr = new int[nums1.length + nums2.length][2];

        int i = 0, j = 0, n = nums1.length, m = nums2.length, k = 0;

        while(i < n && j < m){
            if(nums1[i][0] == nums2[j][0]){
                arr[k++] = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                ++i; ++j;
            } else if(nums1[i][0] < nums2[j][0]){
                arr[k++] = new int[]{nums1[i][0], nums1[i][1]};
                ++i;
            } else{
                arr[k++] = new int[]{nums2[j][0], nums2[j][1]};
                ++j;
            }
        }

        while(i < n){
            arr[k++] = new int[]{nums1[i][0], nums1[i][1]};
            ++i;
        }

        while(j < n){
            arr[k++] = new int[]{nums2[j][0], nums2[j][1]};
            ++j;
        }

        int res[][] = new int[k][2];

        for(int l = 0; l < k; ++l){
            res[l] = arr[l];
        }

        return res;
    }
}