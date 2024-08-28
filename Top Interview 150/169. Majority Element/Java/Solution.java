class Solution {
    public int majorityElement(int[] nums) {
        int total = 0; // if majority element, total will be non-negative
        int majorityElement = nums[0]; // start with the first element to skip a loop cycle
        for(int i=1; i<nums.length; i++) {
            // same element, count++ | different element, count--
            total += (nums[i] == majorityElement) ? 1 : -1;
            // if new majorityElement is found, update majorityElement and total
            if(total < 0) {
                total = 0;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}