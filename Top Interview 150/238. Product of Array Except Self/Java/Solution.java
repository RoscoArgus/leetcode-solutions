import java.util.Arrays;
class Solution {

    /* initial solution, kinda cheating with Math.pow, not very efficient
    public int[] productExceptSelf(int[] nums) {
        // case 1: 1 zero, therefore everything except that index is the full product of non-zeros
        // case 2: > 1 zeros, therefore return 0s array
        // case 3: no zeros, therefore perform intended operation

        int n = nums.length;
        int zeroIndex = -1; // there are no zeros so far
        int product = 1;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                if(zeroIndex != -1) { // case 2
                    return new int[n];
                }
                zeroIndex = i; // case 1
            }
            else {
                product *= nums[i];
            }
        }

        // case 1 
        if(zeroIndex != -1) {
            for(int i=0; i<n; i++) {
                if(i == zeroIndex)
                    nums[i] = product;
                else
                    nums[i] = 0;
            }
        }
        //case 3
        else {
            for(int i=0; i<n; i++) {
                nums[i] = (int)((double)product * Math.pow(nums[i], -1));
            }
        }

        return nums;
    }*/

    // better solution: get prefix and suffix products
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            // fill ans with prefix products
            for(int i=0, left=1; i<n; i++) {
                ans[i] *= currentProduct;
                left *= nums[i];
            }
            // multiply ans with suffix products
            for(int i=n-1, right=1; i>=0; i--) {
                ans[i] *= currentProduct;
                right *= nums[i];
            }

            return ans;
        }
    }
}