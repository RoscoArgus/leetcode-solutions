class Solution {
    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for(int i=0; i < nums.length; i++) {
            // as long as element does not equal val...
            if(nums[i] != val) {
                // ...make the next valid index in the array this value
                nums[currentIndex] = nums[i];
                currentIndex++; // ...and mark next valid index. This is also our result k
            }
        }
        return currentIndex;
    }
}

/* this was my initial solution. Swapping elements unnecessary. Be sure to read the problem fully.

    public int removeElementAlt(int[] nums, int val) {
        int endIndex = nums.length-1; // index to move instances of val to
        int currentIndex = 0; // currently comparing index
        // check each element in the array
        for(int i=0; i < nums.length; i++) {
            // if the current element is equal to val
            if(nums[currentIndex] == val) {
                // swap elements
                nums[currentIndex] += nums[endIndex];
                nums[endIndex] = nums[currentIndex] - nums[endIndex];
                nums[currentIndex] -= nums[endIndex];

                // now move instances of val one index left
                endIndex--;
            }
            else {
                // otherwise, check the next element. This is also the number of non-val elements
                currentIndex++;
            }
        }
        return currentIndex;
    }
        
*/