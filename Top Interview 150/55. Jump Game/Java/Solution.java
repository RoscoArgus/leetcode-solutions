class Solution {
    public boolean canJump(int[] nums) {
        int currentGoal = nums.length-1; // start with goal index

        for(int i=nums.length-2; i>=0; i--) {
            // we can reach the currentGoal from the previous index, update the goal
            if(i + nums[i] >= currentGoal) {
                currentGoal = i;
            } 
        }
        // if we can reach the first index, then we can reach the last index
        return currentGoal == 0;
    }
}