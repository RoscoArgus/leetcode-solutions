class Solution {
    // most solutions used split or for loops but this was cleaner
    public int lengthOfLastWord(String s) {
        String trimString = s.trim();
        int index = trimString.lastIndexOf(" ");
        return trimString.length()-1 - index;
    }
}