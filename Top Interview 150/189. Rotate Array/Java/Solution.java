class Solution {

    /*
     * Learned solution, not original. Achieves O(n) time complexity and O(1) space complexity.
     */

    public void rotate(int[] nums, int k) {
        // rotating k times is the same as rotating k % nums.length times, so reduce
        k %= nums.length; 
        // reverse array entirely...
        reverse(nums, 0, nums.length-1);
        // ...then reverse the first k elements...
        reverse(nums, 0, k-1);
        // ...and finally reverse the remaining elements
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}