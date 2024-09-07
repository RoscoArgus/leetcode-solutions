class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            // skip duplicates
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;

            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                // if sum is too small, increment left pointer
                if(sum < 0)
                    left++;
                // if sum is too large, decrement right pointer
                else if (sum > 0) 
                    right--;
                // if sum is 0, add to result and increment left and decrement right
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // while left is the same as the previous left, increment left
                    while(left<right && nums[left] == nums[left-1])
                        left++;
                    // while right is the same as the previous right, decrement right
                    while(left<right && nums[right] == nums[right+1])
                        right--;
                }
            }
        }
        return result;
    }
}