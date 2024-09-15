class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindow = Integer.MAX_VALUE;
        int left=0;
        int sum = 0;
        int n = nums.length;

        // get sum from left to right
        for(int right=0; right<n; right++) {
            sum += nums[right];
            // when the sum is greater than target, we can move left pointer to right
            while(sum >= target) {
                minWindow = Math.min(minWindow, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        // if max value, no window found (return 0), otherwise return minWindow
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }
}