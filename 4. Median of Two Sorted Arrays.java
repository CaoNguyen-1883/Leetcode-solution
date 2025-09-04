// class Solution {
//     public int[] mergeList(int[] nums1, int[] nums2){
//         int[] ans = new int[nums1.length + nums2.length];

//         int l = 0, r = 0;
//         int i = 0;

//         while(l < nums1.length && r < nums2.length){
//             if(nums1[l] < nums2[r]){
//                 ans[i++] = nums1[l++];
//             } else{
//                 ans[i++] = nums2[r++];
//             }
//         }

//         while(l < nums1.length) ans[i++] = nums1[l++];
//         while(r < nums2.length) ans[i++] = nums2[r++];

//         return ans;
//     }
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] l = this.mergeList(nums1, nums2);
//         int len = nums1.length + nums2.length;
//         for(int i : l) System.out.println(i);
//         if(len % 2 == 0) return (l[len/2] + l[len/2 - 1]) / 2.0;

//         return l[len/2];
//     }
// }

class Solution {
    private int p1 = 0;
    private int p2 = 0;

    public int getMin(int[] nums1, int[] nums2){
        if(p1 < nums1.length && p2 < nums2.length){
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if(p1 < nums1.length){
            return nums1[p1++];
        } else if(p2 < nums2.length){
            return nums2[p2++];
        } 
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;

        if(total % 2 == 0){
            for(int i = 0; i < total/2 - 1; ++i) getMin(nums1, nums2);

            return (double)(getMin(nums1, nums2) + getMin(nums1, nums2))/2;
        }

        for(int i = 0; i < total/2; ++i) getMin(nums1, nums2);
        return getMin(nums1, nums2);
    }
}