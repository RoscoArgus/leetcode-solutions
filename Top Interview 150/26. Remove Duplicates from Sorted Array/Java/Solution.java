class Solution {
    public int removeDuplicates(int[] nums) {
        // index to store non-dupe elements
        int currentIndex = 1;
        for(int i=1; i<nums.length; i++) {
            // if unique, store at currentIndex and incremenet currentIndex
            if(nums[i] != nums[i-1]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        return currentIndex;
    }
}