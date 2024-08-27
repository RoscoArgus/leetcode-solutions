class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        int result = n;
    
        // compare prev elements
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                int diff = candies[i-1]+1 - candies[i];
                candies[i] += diff;
                result += diff; // add increase to result
            }
        }

        // compare next elements
        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                int diff = Math.max(candies[i], candies[i+1]+1) - candies[i];
                candies[i] += diff;
                result += diff; // add increase to result
            }
        }

        return result;
    }
}