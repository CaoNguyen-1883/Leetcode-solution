/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    let res = [];
    let st = new Set();

    for(let i = 0; i < nums1.length; ++i) st.add(nums1[i]);

    for(let i = 0;i < nums2.length; ++i){
        if(st.delete(nums2[i]))
            res.push(i);
    }

    return res;
};