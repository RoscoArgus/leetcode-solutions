class Solution {
    public int strStr(String haystack, String needle) {
        // for each character, check if needle is partly constructed
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    /*
     * equally, this method is already implemented in Java
        return haystack.indexOf(needle);
     */
}