class Solution {
    public int lengthOfLongestSubstring(String s) {
        // store the most recent index of each character
        Map<Character, Integer> indexInSubstring = new HashMap<>();
        int left=0;
        int maxLength = 0;
        int n = s.length();

        for(int right=0; right<n; right++) {
            char currentChar = s.charAt(right);
            // if the character is in the string and is within the current substring
            // move left pointer to the right of the same character
            if(indexInSubstring.containsKey(currentChar) 
                && indexInSubstring.get(currentChar)>=left
            ) {
                left = indexInSubstring.get(currentChar)+1;
            }
            // otherwise, update the maxLength
            else {
                maxLength = Math.max(maxLength, right-left+1);
            }
            // update the most recent index of the character
            indexInSubstring.put(currentChar, right);
        }

        return maxLength;
    }
}