class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int current = 0;
        // iterate until left and right pointers meet
        while(left<right) {
            current = numbers[left] + numbers[right];
            // if current sum is less than target, move left pointer to the right
            if(current < target) 
                left++;
            // if current sum is greater than target, move right pointer to the left
            else if(current > target)
                right--;
            // if current sum is equal to target, return solution;
            else
                return new int[]{left+1, right+1};
        }
        // no solution case, should never be reached
        return new int[]{-1,-1};
    }
}