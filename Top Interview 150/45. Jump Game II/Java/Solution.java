class Solution {
    public int jump(int[] nums) {
        int near = 0; 
        int far = 0; 
        int jumps = 0;

        while (far < nums.length - 1) {
            // furthest index reachable
            int farthest = 0;
            // between current index and furthest reachable...
            for (int i = near; i <= far; i++) {
                // set furthest value reachable as of nums[i]
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1; // start is old farthest reachable point + 1
            far = farthest; // far is new farthest reachable point
            jumps++; // add jump
        }

        return jumps;        
    }
}