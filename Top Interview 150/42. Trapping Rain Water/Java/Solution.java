class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        // basically as long as there is a wall of equal or greater height on either side, 
        // we can trap water
        // track outer maximums
        while (left < right) {
            // if leftMax is smaller than rightMax, then we can trap water at left
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            }
            // otherwise we can trap water at the right.  
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }
}