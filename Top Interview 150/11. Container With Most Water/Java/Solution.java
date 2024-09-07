class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while(left<right) {
            // set maxArea to max of itself and the current area
            max = Math.max(max, Math.min(height[left], height[right]) * (right-left));
            // move the pointer with the smaller height
            if(height[left] < height[right])
                left++;
            else 
                right--;
        }

        return max;
    }
}