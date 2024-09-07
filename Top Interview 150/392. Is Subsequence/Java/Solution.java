class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        // iterate until we reach the end of s or t (early exit with s)
        while(sPointer<s.length() && tPointer<t.length()) {
            if(s.charAt(sPointer) == t.charAt(tPointer))
                sPointer++;
            tPointer++;
        }

        // if we reached the end of s, then s is a subsequence of t
        return sPointer == s.length();
    }
}