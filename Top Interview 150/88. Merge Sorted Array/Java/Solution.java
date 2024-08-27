class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1; // starting index of nums1
        int index2=n-1; // starting index of nums2

        // merge from the end of the array as to not overwrite nums1
        for(int i=m+n-1; i>=0; i--) {
            // early exit when nums2 depleted (nums1 already in place)
            if(index2 < 0) break;

            // if nums1 is depleted or nums2 is greater than nums1
            if(index1 < 0 || nums2[index2] > nums1[index1]) {
                nums1[i] = nums2[index2];
                index2--;
            }
            // else, nums1 is greater than nums2
            else {
                nums1[i] = nums1[index1];
                index1--;
            }
        }
    }
}