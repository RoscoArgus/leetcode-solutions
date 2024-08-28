class Solution {
    public int removeDuplicates(int[] nums) {
        // index to store non-dupe elements
        int currentIndex = 2;
        for(int i=2; i<nums.length; i++) {
            // if element != element prev to last valid element (1 or 2 instances)...
            // ...store at currentIndex and increment
            if(nums[i] != nums[currentIndex-2]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        return currentIndex;
    }
}